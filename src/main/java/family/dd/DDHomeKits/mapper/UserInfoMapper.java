package family.dd.DDHomeKits.mapper;

import family.dd.DDHomeKits.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    @Select("Select * from UserInfo where userId=#{userId}")
    @Results({
            @Result(property="userId", column="userId"),
            @Result(property="username", column="username"),
            @Result(property="password", column="password"),
            @Result(property="nickName", column="nickName"),
            @Result(property="status", column="status", typeHandler = family.dd.DDHomeKits.mapper.UserStatusTypeHandler.class),
            @Result(property="authority", column="authority"),
            @Result(property="extraInfo", column="extraInfo", typeHandler = family.dd.DDHomeKits.mapper.UserExtraInfoTypeHandler.class),
            @Result(property="signUpDate", column="signUpDate")
    })
    List<UserInfo> findUserById(int userId);

    @Select("Select * from UserInfo where account=#{account}")
    @Results({
            @Result(property="userId", column="userId"),
            @Result(property="username", column="username"),
            @Result(property="password", column="password"),
            @Result(property="nickName", column="nickName"),
            @Result(property="status", column="status", typeHandler = family.dd.DDHomeKits.mapper.UserStatusTypeHandler.class),
            @Result(property="authority", column="authority"),
            @Result(property="extraInfo", column="extraInfo", typeHandler = family.dd.DDHomeKits.mapper.UserExtraInfoTypeHandler.class),
            @Result(property="signUpDate", column="signUpDate")
    })
    List<UserInfo> findUserByAccount(String account);

    @Insert("Insert into UserInfo(username," +
            "password," +
            "nickName," +
            "status," +
            "authority," +
            "extraInfo," +
            "signUpDate) values(#{userInfo.username}," +
            "#{userInfo.password}，" +
            "#{userInfo.nickName}，" +
            "#{userInfo.status,typeHandler=family.dd.DDHomeKits.mapper.UserStatusTypeHandler}，" +
            "#{userInfo.authority}，" +
            "#{userInfo.extraInfo, typeHandler=family.dd.DDHomeKits.mapper.UserExtraInfoTypeHandler}，" +
            "#{userInfo.signUpDate}")
    void addUser(UserInfo userInfo);
}
