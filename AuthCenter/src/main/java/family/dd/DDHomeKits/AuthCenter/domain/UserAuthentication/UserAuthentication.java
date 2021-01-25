package family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication;

import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity.Authenticator;
import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity.Privilege;
import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity.User;
import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity.UserStatus;
import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity.UserManager;
import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity.handler.PasswordHandler;
import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity.handler.PasswordHandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

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
        user = authenticator.authenticate(username, encryptedPassword);
        return user;
    }

    public void login(HttpSession session){
        session.setAttribute("userId", user.getUserId());
        session.setAttribute("username", user.getUsername());
        session.setAttribute("status", user.getStatus());
        session.setAttribute("authority", user.getAuthority());
        session.setAttribute("signUpDate", user.getSignUpDate());
        user.setSessionId(session.getId());
        user.login();
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
