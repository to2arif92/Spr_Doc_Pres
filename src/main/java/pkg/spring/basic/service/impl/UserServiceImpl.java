package pkg.spring.basic.service.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pkg.spring.basic.dao.UserDAO;
import pkg.spring.basic.dto.RegistrationForm;
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
        userDAO.addUser(user);
        logger.info("User added, User details="+user);
    }

    @Transactional
    @Override
    public void registerNewUser(RegistrationForm form) {
        if (userDAO.findUserByUsername(form.getUserName()) != null){
            logger.error("User with username: {} Already exist!", form.getUserName());
            return;
        }
        userDAO.registerUser(form);
    }

    @Transactional
    @Override
    public String registerUserFromSocial(Connection<?> connection) {
        return userDAO.registerUserFromSocial(connection);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
        logger.info("User updated, User details="+user);
    }

    @Transactional
    @Override
    public void removeUser(String userName) {
        userDAO.removeUser(userName);
        logger.info("User removed by username: "+userName);
    }

    @Transactional
    @Override
    public User findUserByUsername(String userName) {
        logger.info("Retrieving User by username: "+userName);
        return userDAO.findUserByUsername(userName);
    }

    @Transactional
    @Override
    public User findUserById(String Id) {
        /*User user = userDAO.findUserById(Id);
        logger.debug("Found user: {}", user);
        return user;*/
        return userDAO.findUserById(Id);
    }

    @Transactional
    @Override
    public String findUserRoleByPrivilegeId(long user_privilegeID) {
        logger.trace("Retrieving the role by id: "+user_privilegeID);
        return userDAO.findUserRoleByPrivilegeId(user_privilegeID);
    }

    @Transactional
    @Override
    public List<User> listUsers() {
        return userDAO.listUsers();
    }
}
