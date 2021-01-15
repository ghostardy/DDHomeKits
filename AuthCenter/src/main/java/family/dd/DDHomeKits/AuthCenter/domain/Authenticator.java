package family.dd.DDHomeKits.AuthCenter.domain;

import family.dd.DDHomeKits.AuthCenter.dao.UserIdentityPO;
import family.dd.DDHomeKits.AuthCenter.dao.UserRepository;
import family.dd.DDHomeKits.AuthCenter.domain.handler.PasswordHandler;
import family.dd.DDHomeKits.AuthCenter.domain.handler.PasswordHandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Authenticator {
    private UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * Authorize user and put user info into cache
     * @param username username inputted by front user
     * @param password password inputted by front user
     * @return HandleResult
     */
    public User authenticate(String username, String password) throws HandlePasswordException{
        /**
         * Check password inputted by front user
         */
        String handledPassword = transPassword(username, password);

        List<UserIdentityPO> members = repository.find(username, handledPassword);

        if(members.size() == 1) {
            return new User(members.get(0));
        }
        return null;
    }
    /**
     * Handle password inputted by front user
     * @param username Use username as seed of password handler
     * @param password unhandled password
     * @throws Exception when failed to handle password
     * @return handled password
     */
    public static String transPassword(String username, String password) throws HandlePasswordException {
        try{
            PasswordHandler pwdHandler = PasswordHandlerFactory.getInstance();
            return pwdHandler.handle(password, username);
        }catch (Exception e) {
            throw new HandlePasswordException("Server ERROR, Login Failed!");
        }
    }
}
