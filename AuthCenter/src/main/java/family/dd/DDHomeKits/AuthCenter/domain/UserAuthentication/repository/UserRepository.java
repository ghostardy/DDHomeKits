package family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  User Repository
 *  Database Table is UserIdentity
 */
@Repository
public class UserRepository {
    /**
     * Mapper managed by mybatis
     */
    private UserIdentityMapper userIdentityMapper;

    /**
     * Used in login situation
     * @param username
     * @param password
     * @return User lists
     */
    public List<UserIdentityPO> find(String username, String password) {
        return userIdentityMapper.findByUsernameAndPassword(username, password);
    }

    /**
     * Used in sign up situation
     * @param username
     * @return User lists
     */
    public List<UserIdentityPO> find(String username) {
        return userIdentityMapper.findByUsername(username);
    }

    /**
     * Used by signed in users
     * @param userId
     * @return User lists
     */
    public List<UserIdentityPO> find(int userId) {
        return userIdentityMapper.findByUserid(userId);
    }

    /**
     * For user management
     * @param userInfo
     */
    public void add(UserIdentityPO userInfo){
        userIdentityMapper.add(userInfo);
    }

    /**
     * For test use
     * @param username
     */
    public void removeByUsername(String username){
        userIdentityMapper.removeByUsername(username);
    }

    @Autowired
    public void setMapper(UserIdentityMapper userIdentityMapper) {
        this.userIdentityMapper = userIdentityMapper;
    }
}
