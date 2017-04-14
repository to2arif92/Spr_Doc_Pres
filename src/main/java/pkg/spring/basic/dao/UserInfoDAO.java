package pkg.spring.basic.dao;

import org.springframework.stereotype.Repository;
import pkg.spring.basic.model.UserInfo;

import java.util.List;

/**
 * Created by ArIF on 14-Apr-17.
 */
@Repository
public interface UserInfoDAO {

    public UserInfo getUserInfo(String userName);

    List<String> getUserRoles(String userName);
}
