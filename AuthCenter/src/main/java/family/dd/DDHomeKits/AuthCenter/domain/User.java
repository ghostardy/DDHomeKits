package family.dd.DDHomeKits.AuthCenter.domain;

import com.google.gson.Gson;
import family.dd.DDHomeKits.AuthCenter.dao.UserRepository;
import family.dd.DDHomeKits.AuthCenter.dao.UserIdentityPO;
import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthCenter.dao.HandleResult;
import family.dd.DDHomeKits.AuthCenter.domain.handler.PasswordHandler;
import family.dd.DDHomeKits.AuthCenter.domain.handler.PasswordHandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Users action as family member
 */
@Component
@Scope("prototype")
public class User {
    private UserRepository repository;
    private UserIdentityPO userIdentity;

    public UserIdentityPO getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(UserIdentityPO userIdentity) {
        this.userIdentity = userIdentity;
    }

    private Gson gson = new Gson();

    HandleResult recover(String memberId){
        return new HandleResult(ResponseCode.SUCCESS, "Family member login status is recovered");
    }

    /**
     * Authorize user and put user info into cache
     * @param username username inputted by front user
     * @param password password inputted by front user
     * @return HandleResult
     */
    public HandleResult authenticate(String username, String password){
        /**
         * Check password inputted by front user
         */
        String handledPassword;
        try{
            handledPassword = transPassword(username, password);
        }catch (Exception e) {
            return new HandleResult(ResponseCode.SERVER_ERROR, "Server ERROR, Login Failed!");
        }
        List<UserIdentityPO> members = repository.find(username, handledPassword);

        if(members.size() != 1) {
            return new HandleResult(ResponseCode.REQUEST_FAILURE, "Authenticate Failed! Invalid username or password");
        }

        userIdentity = members.get(0);
        return new HandleResult(ResponseCode.SUCCESS, gson.toJson(userIdentity));
    }
    /**
     * Handle password inputted by front user
     * @param username Use username as seed of password handler
     * @param password unhandled password
     * @throws Exception when failed to handle password
     * @return handled password
     */
    public String transPassword(String username, String password) throws Exception{
        PasswordHandler pwdHandler = PasswordHandlerFactory.getInstance();
        return pwdHandler.handle(password, username);
    }
    /**
     * Sign up new user, only used by inner service
     * @param userInfo
     * @return HandleResult
     */
    public HandleResult singUp(UserIdentityPO userInfo){
        UserIdentityPO newUser = new UserIdentityPO(userInfo);
        List<UserIdentityPO> users = repository.find(newUser.getUsername());
        if(users.size() != 0) {
            return new HandleResult(ResponseCode.REQUEST_FAILURE, "Can not sign up by username: " +
                    newUser.getUsername() + ". Please try another one.");
        }

        try{
            newUser.setPassword(transPassword(newUser.getUsername(), newUser.getPassword()));
            repository.add(newUser);
        } catch (Exception e){
            return new HandleResult(ResponseCode.SERVER_ERROR, "Failed to sign up user, please try again later");
        }
        return new HandleResult(ResponseCode.SUCCESS, "Thanks for Signing Up");
    }

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }
}
