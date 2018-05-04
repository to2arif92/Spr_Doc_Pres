package pkg.spring.basic.service;

import org.springframework.social.connect.Connection;
import pkg.spring.basic.dto.RegistrationForm;
import pkg.spring.basic.model.auth.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void registerNewUser(RegistrationForm form);
    String registerUserFromSocial(Connection<?> connection);
    void updateUser(User user);
    void removeUser(String userName);
    User findUserByUsername(String userName);
    User findUserById(String Id);
    List<User> listUsers();

    String findUserRoleByPrivilegeId(long user_privilegeID);
}
