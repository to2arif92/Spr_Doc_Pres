package pkg.spring.basic.service;

import pkg.spring.basic.model.auth.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void removeUser(String userName);
    User getUser(String userName);
    List<User> listUsers();

    String getUserRole(long user_privilegeID);
}
