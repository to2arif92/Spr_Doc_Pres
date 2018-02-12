package pkg.spring.basic.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pkg.spring.basic.dao.UserDAO;
import pkg.spring.basic.model.auth.User;

import java.util.List;

/**
 * Created by ArIF on 19-Jun-17.
 */

/* HQL is used here, which translates to SQL for the used Datasource */

@Repository
public class UserDAOImpl implements UserDAO{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // get the configured SessionFactory bean
    @Autowired
    private SessionFactory sessionFactory;

    // to get rid of instantiating Session obj in all methods
    private Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

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
    public void removeUser(String userName) {
        User user = getSession().load(User.class, userName);
        if (user != null){
            getSession().delete(user);
            logger.info("User:"+user+" is Removed");
        }
    }

    @Override
    public User getUser(String userName) {
        User user = getSession().load(User.class, userName);
        if (user != null){
            logger.trace("User Found: "+user);
            return user;
        } else {
            logger.warn("No User found by username: "+userName);
            return null;
        }
    }

    @Override
    public String getUserRole(long user_privilegeID) {
        Query query = getSession().createQuery("select p.privilegeType from UserPrivilege p where p.id = :pID");
        query.setParameter("pID", user_privilegeID);
        /*String role = ( String ) query.getSingleResult();
        logger.trace(role);*/
        return ( String ) query.getSingleResult();
    }

    @Override
    public List<User> listUsers() {
        List<User> userList = getSession().createQuery("from User").list();
        logger.info("User list::"+userList.toString());


        return userList;
    }


    /*
    * Compatible while a single User can have multiple Roles, thus used List
    @Override
    public List<String> getUserRole(long privilegeID) {
        Query query = getSession().createQuery("select p.privilegeType from UserPrivilege p where p.id = :pID");
        query.setParameter("pID", privilegeID);
        List<String> roles = query.list();
         //logger.info(roles.toString());

        return roles;
    }
    *
    * */

    /* Operation by integer UserID

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
    }*/
}
