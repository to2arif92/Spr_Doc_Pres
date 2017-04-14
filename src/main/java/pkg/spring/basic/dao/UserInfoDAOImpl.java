package pkg.spring.basic.dao;

import pkg.spring.basic.dao.UserInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pkg.spring.basic.mapper.UserInfoMapper;
import pkg.spring.basic.model.UserInfo;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by ArIF on 14-Apr-17.
 */
@Service
@Transactional
public class UserInfoDAOImpl extends JdbcDaoSupport implements UserInfoDAO {

    @Autowired
    public UserInfoDAOImpl(DataSource dataSource) {
        // from extended JDBC
        this.setDataSource(dataSource);
    }

    @Override
    public UserInfo getUserInfo(String userName) {
        String sql = "Select u.Username,u.Password "//
                + " from Users u where u.Username = ? ";
        Object[] params = new Object[] {userName};
        UserInfoMapper mapper = new UserInfoMapper();
        try {
            UserInfo userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return userInfo;
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<String> getUserRoles(String userName) {
        String sql = "Select r.User_Role "//
                + " from User_Roles r where r.Username = ? ";

        Object[] params = new Object[] { userName };

        List<String> roles = this.getJdbcTemplate().queryForList(sql,params, String.class);

        return roles;
    }
}
