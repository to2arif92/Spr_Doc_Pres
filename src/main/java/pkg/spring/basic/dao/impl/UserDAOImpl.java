package pkg.spring.basic.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import pkg.spring.basic.dao.UserDAO;
import pkg.spring.basic.model.User;

import java.util.List;

/**
 * Created by ArIF on 19-Jun-17.
 */

@Repository
public class UserDAOImpl implements UserDAO{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().persist(user);
        logger.info("User added, User details="+user);
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User updated, User details="+user);
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        if (null != user){
            session.delete(user);
            logger.info("User deleted, User details="+user);
        }
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        logger.info("User loaded, User details="+user);

        return user;
    }

    @Override
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        for (User u: userList){
            logger.info("User list::"+u);
        }

        return userList;
    }
}
