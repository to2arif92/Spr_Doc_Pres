package pkg.spring.basic.mapper;

import org.springframework.jdbc.core.RowMapper;
import pkg.spring.basic.model.UserInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ArIF on 14-Apr-17.
 */
public class UserInfoMapper implements RowMapper<UserInfo>{

    @Override
    public UserInfo mapRow(ResultSet rs, int i) throws SQLException {

        String userName = rs.getString("Username");
        String passWord = rs.getString("Password");

        return new UserInfo(userName, passWord);
    }
}