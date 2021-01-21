package family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity;

import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.repository.UserIdentityPO;
import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.repository.UserRepository;
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
     * @param encryptedPassword encrypted password inputted by front user
     * @return HandleResult
     */
    public User authenticate(String username, String encryptedPassword){
        /**
         * Check password inputted by front user
         */
        List<UserIdentityPO> members = repository.find(username, encryptedPassword);

        if(members.size() == 1) {
            return new User(members.get(0));
        }
        return null;
    }

    public boolean hasPermission(User user, Privilege p) {
        return Privilege.hasPermission(user.getAuthority(), p);
    }
}
