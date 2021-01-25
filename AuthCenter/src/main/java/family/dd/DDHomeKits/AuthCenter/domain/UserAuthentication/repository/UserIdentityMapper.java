package family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.repository;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Managed by mybatis
 */
@Mapper
public interface UserIdentityMapper {
    @Select("Select userId," +
            "username," +
            "status," +
            "authority," +
            "signUpDate" +
            " from UserIdentity where userId=#{userId}")
    @Results({
            @Result(property="userId", column="userId"),
            @Result(property="username", column="username"),
            @Result(property="status", column="status", typeHandler = UserStatusTypeHandler.class),
            @Result(property="authority", column="authority"),
            @Result(property="signUpDate", column="signUpDate")
    })
    List<UserIdentityPO> findByUserid(int userId);

    @Select("Select userId," +
            "username," +
            "status," +
            "authority," +
            "signUpDate" +
            " from UserIdentity where username=#{username}")
    @Results({
            @Result(property="userId", column="userId"),
            @Result(property="username", column="username"),
            @Result(property="status", column="status", typeHandler = UserStatusTypeHandler.class),
            @Result(property="authority", column="authority"),
            @Result(property="signUpDate", column="signUpDate")
    })
    List<UserIdentityPO> findByUsername(String username);

    @Select("Select userId," +
            "username," +
            "status," +
            "authority," +
            "signUpDate" +
            " from UserIdentity where username=#{username} and password=#{password}")
    @Results({
            @Result(property="userId", column="userId"),
            @Result(property="username", column="username"),
            @Result(property="status", column="status", typeHandler = UserStatusTypeHandler.class),
            @Result(property="authority", column="authority"),
            @Result(property="signUpDate", column="signUpDate")
    })
    List<UserIdentityPO> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Insert("Insert into UserIdentity(username," +
            "password," +
            "status," +
            "authority," +
            "signUpDate) values(#{username}," +
            "#{password}," +
            "#{status,typeHandler=UserStatusTypeHandler}," +
            "#{authority}," +
            "#{signUpDate})")
    void add(UserIdentityPO userIdentity);

    @Delete("Delete from UserIdentity where username = #{username}")
    void removeByUsername(String username);
}
