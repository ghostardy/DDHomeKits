package family.dd.DDHomeKits.member;

import family.dd.DDHomeKits.entity.UserInfo;
import family.dd.DDHomeKits.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class FamilyMemberRepository {
    private UserInfoMapper mapper;
    UserInfo[] getUserInfo(String account) {
        return new UserInfo[]{new UserInfo("","")};
    }
    List<UserInfo> getUserInfo(int userId) {
        return mapper.findUserById(userId);
    }

    public UserInfoMapper getMapper() {
        return mapper;
    }

    @Autowired
    public void setMapper(UserInfoMapper mapper) {
        this.mapper = mapper;
    }
}
