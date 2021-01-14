package family.dd.DDHomeKits.AuthCenter.domain;

import family.dd.DDHomeKits.AuthCenter.dao.UserIdentityPO;
import family.dd.DDHomeKits.AuthCenter.dao.UserRepository;
import family.dd.DDHomeKits.AuthCenter.domain.handler.PasswordHandler;
import family.dd.DDHomeKits.AuthCenter.domain.handler.PasswordHandlerFactory;
import family.dd.DDHomeKits.AuthCenter.util.CommonUtil;
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
        String handledPassword = CommonUtil.transPassword(username, password);

        List<UserIdentityPO> members = repository.find(username, handledPassword);

        if(members.size() == 1) {
            return new User(members.get(0));
        }
        return null;
    }
}
