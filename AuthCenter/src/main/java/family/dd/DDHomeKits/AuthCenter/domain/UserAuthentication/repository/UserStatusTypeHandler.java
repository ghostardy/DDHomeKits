package family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.repository;

import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity.UserStatus;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(UserStatus.class)
public class UserStatusTypeHandler extends BaseTypeHandler<UserStatus> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, UserStatus userStatus, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, userStatus.getStatusCode());
    }

    @Override
    public UserStatus getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return UserStatus.getUserStatus(resultSet.getInt(s));
    }

    @Override
    public UserStatus getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return UserStatus.getUserStatus(resultSet.getInt(i));
    }

    @Override
    public UserStatus getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return UserStatus.getUserStatus(callableStatement.getInt(i));
    }
}
