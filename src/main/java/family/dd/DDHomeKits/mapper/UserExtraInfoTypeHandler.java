package family.dd.DDHomeKits.mapper;

import com.google.gson.Gson;
import family.dd.DDHomeKits.entity.UserExtraInfo;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(UserExtraInfo.class)
public class UserExtraInfoTypeHandler extends BaseTypeHandler<UserExtraInfo> {
    private Gson gson = new Gson();
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, UserExtraInfo userExtraInfo, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, gson.toJson(userExtraInfo));
    }

    @Override
    public UserExtraInfo getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return gson.fromJson(resultSet.getString(s), UserExtraInfo.class);
    }

    @Override
    public UserExtraInfo getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return gson.fromJson(resultSet.getString(i), UserExtraInfo.class);
    }

    @Override
    public UserExtraInfo getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return gson.fromJson(callableStatement.getString(i), UserExtraInfo.class);
    }
}
