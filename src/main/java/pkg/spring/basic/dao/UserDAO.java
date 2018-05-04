package pkg.spring.basic.dao;

import org.springframework.social.connect.Connection;
import pkg.spring.basic.dto.RegistrationForm;
import pkg.spring.basic.model.auth.User;

import java.util.List;

/**
 * Created by ArIF on 19-Jun-17.
 */
public interface UserDAO {
    void addUser(User user);
    void registerUser(RegistrationForm registrationForm);
    /**
     * Register new user automatically on social sign-in attempt
     * @param connection    Data from provider's sign-in attempt
     * @return  Return username of auto created user, otherwise existing
     */
    String registerUserFromSocial(Connection<?> connection);
    void updateUser(User user);
    void removeUser(String userName);
    User findUserById(String id);
    User findUserByUsername(String userName);
    User findUserByEmail(String email);
    List<User> listUsers();

    String findUserRoleByPrivilegeId(long user_privilegeID);
}
