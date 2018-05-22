package pkg.spring.basic.dao.impl;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.UserProfile;
import org.springframework.stereotype.Repository;
import pkg.spring.basic.dao.UserDAO;
import pkg.spring.basic.dto.RegistrationForm;
import pkg.spring.basic.model.auth.User;
import pkg.spring.basic.model.auth.UserPrivilege;

import java.util.List;
import java.util.UUID;

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
        logger.trace("Adding user: "+user.toString());
    }

    @Override
    public void registerUser(RegistrationForm registrationForm) {
        User user = buildUserByForm(registrationForm);
        logger.trace("Saving User with data: {}", user.toString());
        sessionFactory.getCurrentSession().persist(user);
    }


    @Override
    public String registerUserFromSocial(Connection<?> connection) {
        ConnectionKey key = connection.getKey();
        logger.trace("Provider: {} ; UserId: {}", key.getProviderId(), key.getProviderUserId());

        UserProfile userProfile = connection.fetchUserProfile();
        String email = userProfile.getEmail();
        /*If any user's email in the database is matched
         with the sign-in attempt Social user's email
          then halt creating a new user*/
        User user = this.findUserByEmail(email);
        if (user != null){
            logger.debug("User already exist in the database by email: {}", userProfile.getEmail());
            return user.getUserName();
        } else {
            logger.debug("No user found by: {} ; processing registration", email);
        }

        /*Create user*/

        /*Auto create ID & Username*/
        // Random String with 36 char
        String id = UUID.randomUUID().toString();
        String userName_prefix = userProfile.getFirstName().trim().toLowerCase()
                +"_"+userProfile.getLastName().trim().toLowerCase();
        logger.trace("Checking if {} is available", userName_prefix);
        String userName = findAvailableUsername(userName_prefix);

        logger.trace("Username to be used: {}", userName);
        // Populate user class with values
        user = new User();
        user.setId(id); user.setUserName(userName); user.setUserPassword("123456"); user.setFirstName(userProfile.getFirstName()); user.setLastName(userProfile.getLastName()); user.setEmail(email);
        logger.debug("Inserting user with: {}", user);
        getSession().persist(user);
        return userName;
    }

    private String findAvailableUsername(String userName_prefix){
        String userName = userName_prefix;

        Boolean availableFlag = false;
        int count = 0;
        while (!availableFlag){
            User user = this.findUserByUsername(userName_prefix);
            if (user == null){
                logger.trace("Username: {} is available", userName);
                availableFlag = true;
            } else {
                logger.info("User: ", user);
                logger.error("Username: {} is not available", userName);
                userName = userName_prefix+count++;
            }
        }
        return userName;
    }

    /**
     *
     * @param formDTO   Transfers submitted form of user data
     * @return  Returns the User model built from the submitted form
     */
    private User buildUserByForm(RegistrationForm formDTO){
        logger.debug("Building User model from Submitted form");
        User user = new User();
        user.setId(formDTO.getId());
        user.setUserName(formDTO.getUserName());
        user.setUserPassword(formDTO.getPassword());
        /* when multiple privilege is there/ list
        final HashSet<Role> roles = new HashSet<Role>();
        Role role = new Role();
        role.setName("ROLE_USER");
        roles.add(role);*/
        UserPrivilege privilege = new UserPrivilege();
        // TODO: Decide user priviledge option here
        privilege.setId(2L); // USER
        user.setUserPrivilege(privilege);
        user.setLoginStatus(true);

        return user;
    }


    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.trace("Updating user: "+user.toString());
    }

    @Override
    public void removeUser(String userName) {
        User user = getSession().load(User.class, userName);
        if (user != null){
            logger.trace("Removing user by username: "+userName);
            getSession().delete(user);
        }
    }

    @Override
    public User findUserById(String id) {
        logger.trace("Loading user by id: {}", id);

        try {
            User user = getSession().load(User.class, id);
            logger.trace("User found: {}", user);
            return user;
        } catch (ObjectNotFoundException e){
            logger.error("No user found!");
            return null;
        }
    }

    @Override
    public User findUserByUsername(String userName) {
        logger.debug("Loading user by username: {}", userName);

        User user = null;
        try {
            user = getSession().load(User.class, userName);
            logger.trace("User Found: "+user);
            return user;
        } catch (Exception e){
            logger.error("No User found");
            return null;
        }/* finally {
            return user = null;
        }*/
    }

    @Override
    public User findUserByEmail(String email) {
        logger.debug("Loading user by email: {}", email);
        try {
            User user = getSession().load(User.class, email);
            logger.trace("User Found: "+user);
            return user;
        } catch (ObjectNotFoundException e){
            logger.error("No User found");
            return null;
        }

    }

    @Override
    public String findUserRoleByPrivilegeId(long user_privilegeID) {
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
    public List<String> findUserRoleByPrivilegeId(long privilegeID) {
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
