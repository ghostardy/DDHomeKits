package family.dd.DDHomeKits.AuthCenter.domain;

import family.dd.DDHomeKits.AuthCenter.definition.Privilege;
import family.dd.DDHomeKits.AuthCenter.definition.UserStatus;
import family.dd.DDHomeKits.AuthCenter.domain.handler.PasswordHandler;
import family.dd.DDHomeKits.AuthCenter.domain.handler.PasswordHandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AggregateRoot
 */
@Service
public class UserAuthentication {
    private Authenticator authenticator;
    private UserManager userManager;
    private User user;

    public User signUp(User newUserInfo, String userInputPassword) throws HandlePasswordException{
        String encryptedPassword = transPassword(newUserInfo.getUsername(), userInputPassword);
        return userManager.addUser(newUserInfo, encryptedPassword);
    }
    public User authenticate(String username, String userInputPassword) throws HandlePasswordException {
        String encryptedPassword = transPassword(username, userInputPassword);
        return authenticator.authenticate(username, encryptedPassword);
    }


    /**
     * Handle password inputted by front user
     * @param username Use username as seed of password handler
     * @param password unhandled password
     * @throws Exception when failed to handle password
     * @return handled password
     */
    public String transPassword(String username, String password) throws HandlePasswordException {
        try{
            PasswordHandler pwdHandler = PasswordHandlerFactory.getInstance();
            return pwdHandler.handle(password, username);
        }catch (Exception e) {
            throw new HandlePasswordException("Server ERROR, Login Failed!");
        }
    }
    public boolean canLogin(){
        return authenticator.hasPermission(user, Privilege.LOG_IN);
    }
    public boolean isPrepared() {
        return UserStatus.PREPARED.equals(user.getStatus());
    }

    @Autowired
    public void setAuthenticator(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
