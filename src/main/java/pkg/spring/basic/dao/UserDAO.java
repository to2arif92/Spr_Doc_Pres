package pkg.spring.basic.dao;

import pkg.spring.basic.model.auth.User;

import java.util.List;

/**
 * Created by ArIF on 19-Jun-17.
 */
public interface UserDAO {
    void addUser(User user);
    void updateUser(User user);
    void removeUser(int id);
    User getUserById(int id);
    List<User> listUsers();
}
