package family.dd.DDHomeKits.AuthCenter.domain;

import family.dd.DDHomeKits.AuthCenter.dao.UserRepository;
import family.dd.DDHomeKits.AuthCenter.dao.UserIdentityPO;
import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthCenter.dao.HandleResult;
import family.dd.DDHomeKits.AuthCenter.domain.handler.PasswordHandler;
import family.dd.DDHomeKits.AuthCenter.domain.handler.PasswordHandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Users action as family member
 */
@Service
public class User {
    private UserRepository repository;
    private UserIdentityPO userIdentity;

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
        String handledPassword;
        /**
         * Check password inputted by front user
         */
        try {
            handledPassword = transPassword(username, password);
        }catch (Exception e) {
            return new HandleResult(ResponseCode.SERVER_ERROR, "Server ERROR, Login Failed!");
        }
        List<UserIdentityPO> members = repository.find(username, handledPassword);

        if(members.size() != 1) {
            return new HandleResult(ResponseCode.REQUEST_FAILURE, "Login Failed! Invalid username or password");
        }

        userIdentity = members.get(0);
        return new HandleResult(ResponseCode.SUCCESS, "Authentication success");
    }
    /**
     * Handle password inputted by front user
     * @param username Use username as seed of password handler
     * @param password unhandled password
     * @throws Exception when failed to handle password
     * @return handled password
     */
    private String transPassword(String username, String password) throws Exception{
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
        /**
         * Check if username can be used
         */
        if(users.size() != 0) {
            return new HandleResult(ResponseCode.REQUEST_FAILURE, "Can not sign up by username: " +
                    newUser.getUsername() + ". Please try another one.");
        }

        try {
            newUser.setPassword(transPassword(newUser.getUsername(), newUser.getPassword()));
            repository.add(newUser);
        } catch (Exception e){
            return new HandleResult(ResponseCode.SERVER_ERROR, "Failed to sign up user, please try again later");
        }
        return new HandleResult(ResponseCode.SUCCESS, "Thanks for Signing Up");
    }

    public UserRepository getRepository() {
        return repository;
    }

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }
}
