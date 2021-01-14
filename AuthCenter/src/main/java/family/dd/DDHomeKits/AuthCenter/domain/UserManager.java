package family.dd.DDHomeKits.AuthCenter.domain;

import family.dd.DDHomeKits.AuthCenter.dao.HandleResult;
import family.dd.DDHomeKits.AuthCenter.dao.UserIdentityPO;
import family.dd.DDHomeKits.AuthCenter.dao.UserRepository;
import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthCenter.util.CommonUtil;
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
            newUser.setPassword(CommonUtil.transPassword(newUser.getUsername(), newUser.getPassword()));
            repository.add(newUser);
        } catch (Exception e){
            return new HandleResult(ResponseCode.SERVER_ERROR, "Failed to sign up user, please try again later");
        }
        return new HandleResult(ResponseCode.SUCCESS, "Thanks for Signing Up");
    }
}
