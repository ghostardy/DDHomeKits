package family.dd.DDHomeKits.AuthCenter.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Managed by mybatis
 */
@Mapper
public interface UserInfoMapper {
    @Select("Select userId," +
            "username," +
            "nickName," +
            "status," +
            "authority," +
            "extraInfo," +
            "signUpDate" +
            " from IdentificationPO where userId=#{userId}")
    @Results({
            @Result(property="userId", column="userId"),
            @Result(property="username", column="username"),
            @Result(property="nickName", column="nickName"),
            @Result(property="status", column="status", typeHandler = family.dd.DDHomeKits.AuthCenter.dao.UserStatusTypeHandler.class),
            @Result(property="authority", column="authority"),
            @Result(property="extraInfo", column="extraInfo", typeHandler = family.dd.DDHomeKits.AuthCenter.dao.UserExtraInfoTypeHandler.class),
            @Result(property="signUpDate", column="signUpDate")
    })
    List<IdentificationPO> findUserByUserid(int userId);

    @Select("Select userId," +
            "username," +
            "nickName," +
            "status," +
            "authority," +
            "extraInfo," +
            "signUpDate" +
            " from IdentificationPO where username=#{username}")
    @Results({
            @Result(property="userId", column="userId"),
            @Result(property="username", column="username"),
            @Result(property="nickName", column="nickName"),
            @Result(property="status", column="status", typeHandler = UserStatusTypeHandler.class),
            @Result(property="authority", column="authority"),
            @Result(property="extraInfo", column="extraInfo", typeHandler = UserExtraInfoTypeHandler.class),
            @Result(property="signUpDate", column="signUpDate")
    })
    List<IdentificationPO> findUserByUsername(@Param("username") String username);

    @Select("Select userId," +
            "username," +
            "nickName," +
            "status," +
            "authority," +
            "extraInfo," +
            "signUpDate" +
            " from IdentificationPO where username=#{username} and password=#{password}")
    @Results({
            @Result(property="userId", column="userId"),
            @Result(property="username", column="username"),
            @Result(property="nickName", column="nickName"),
            @Result(property="status", column="status", typeHandler = UserStatusTypeHandler.class),
            @Result(property="authority", column="authority"),
            @Result(property="extraInfo", column="extraInfo", typeHandler = UserExtraInfoTypeHandler.class),
            @Result(property="signUpDate", column="signUpDate")
    })
    List<IdentificationPO> findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Insert("Insert into IdentificationPO(username," +
            "password," +
            "nickName," +
            "status," +
            "authority," +
            "extraInfo," +
            "signUpDate) values(#{username}," +
            "#{password}," +
            "#{nickName}," +
            "#{status,typeHandler=family.dd.DDHomeKits.AuthCenter.dao.UserStatusTypeHandler}," +
            "#{authority}," +
            "#{extraInfo, typeHandler=family.dd.DDHomeKits.AuthCenter.dao.UserExtraInfoTypeHandler}," +
            "#{signUpDate})")
    void addUser(IdentificationPO userInfo);

    @Delete("Delete from IdentificationPO where username = #{username}")
    void rmvUser(IdentificationPO userInfo);
}
