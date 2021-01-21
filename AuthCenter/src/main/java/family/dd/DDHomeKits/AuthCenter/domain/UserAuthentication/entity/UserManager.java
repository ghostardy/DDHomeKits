package family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity;

import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.repository.UserIdentityPO;
import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserManager {
    private UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }
    /**
     * Add new user, only used by inner service
     * @param newUserInfo
     * @param encryptedPassword
     * @return HandleResult
     */
    public User addUser(User newUserInfo, String encryptedPassword){
        UserIdentityPO newUserPO = new UserIdentityPO();
        newUserPO.setUsername(newUserInfo.getUsername());
        newUserPO.setPassword(encryptedPassword);
        newUserPO.setStatus(newUserInfo.getStatus());
        newUserPO.setAuthority(newUserInfo.getAuthority());
        newUserPO.setSignUpDate(newUserInfo.getSignUpDate());
        repository.add(newUserPO);
        return usernameExists(newUserPO.getUsername());
    }

    public User usernameExists(String username) {
        List<UserIdentityPO> users = repository.find(username);
        if(users.size() != 0) {
            return new User(users.get(0));
        }
        return null;
    }
}
