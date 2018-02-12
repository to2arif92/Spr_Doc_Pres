package pkg.spring.basic.service.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pkg.spring.basic.dao.UserDAO;
import pkg.spring.basic.model.auth.User;
import pkg.spring.basic.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Logger logger;

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public void addUser(User user) {
        logger.info("Adding user: "+user.toString());
        userDAO.addUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        logger.info("Updating user: "+user.toString());
        userDAO.updateUser(user);
    }

    @Transactional
    @Override
    public void removeUser(String userName) {
        logger.info("Removing user by username: "+userName);
        userDAO.removeUser(userName);
    }

    @Transactional
    @Override
    public User getUser(String userName) {
        logger.info("Retrieving User by username: "+userName);
        return userDAO.getUser(userName);
    }

    @Transactional
    @Override
    public String getUserRole(long user_privilegeID) {
        logger.trace("Retrieving the role by id: "+user_privilegeID);
        return userDAO.getUserRole(user_privilegeID);
    }

    @Transactional
    @Override
    public List<User> listUsers() {
        return userDAO.listUsers();
    }
}
