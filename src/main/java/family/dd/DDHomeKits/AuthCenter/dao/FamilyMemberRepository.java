package family.dd.DDHomeKits.AuthCenter.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  Family member Repository
 *  Store user data into table IdentificationPO
 */
@Repository
public class FamilyMemberRepository {
    /**
     * Mapper managed by mybatis
     */
    private UserInfoMapper mapper;

    /**
     * Used in login situation
     * @param username
     * @param password
     * @return User lists
     */
    public List<IdentificationPO> getUserInfo(String username, String password) {
        return mapper.findUserByUsernameAndPassword(username, password);
    }

    /**
     * Used in sign up situation
     * @param username
     * @return User lists
     */
    public List<IdentificationPO> getUserInfo(String username) {
        return mapper.findUserByUsername(username);
    }

    /**
     * Used by signed in users
     * @param userId
     * @return User lists
     */
    public List<IdentificationPO> getUserInfo(int userId) {
        return mapper.findUserByUserid(userId);
    }

    /**
     * For user management
     * @param userInfo
     */
    void addUserInfo(IdentificationPO userInfo){
        mapper.addUser(userInfo);
    }

    /**
     * For test use
     * @param userInfo
     */
    void rmvUserInfo(IdentificationPO userInfo){
        mapper.rmvUser(userInfo);
    }

    @Autowired
    public void setMapper(UserInfoMapper mapper) {
        this.mapper = mapper;
    }
}
