package pkg.spring.basic.security;

import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pkg.spring.basic.service.UserService;

import java.util.ArrayList;
import java.util.List;

/*
  Created by ArIF on 14-Apr-17.
 */
/**
 * This class (UserDetailsService) is responsible for retrieving user specific Data (User Model object)
 * Define another class(SocialUserDetails/ UserDetails) to create custom instance of User/Principal (Spring Security); holds authenticated user's details
 */

@Service
public class LocalUserDetailsService implements UserDetailsService {

    @Autowired
    private Logger logger;

    @Autowired
    private UserService userService;

    public LocalUserDetailsService() {
    }


    /**
     * Locate the target user;
     * if found in the memory/db : verify against its Password & Role, based on provided values
     */
    //@Bean  // to get the returned UserDetails in SecurityUtils
    /**
     * Loads the user information.
     * @param username  The username of the requested user.
     * @return  The information of the user.
     * @throws UsernameNotFoundException    Thrown if no user is found with the given username.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.debug("Loading user by username: {}", username);

        pkg.spring.basic.model.auth.User targetUser = null;
        try {
            targetUser = userService.findUserByUsername(username);
            logger.trace("Authenticating User: {}", targetUser.getUserName());

        } catch (UsernameNotFoundException | ObjectNotFoundException e){
            logger.error("No User found with username:{} in the database:", username);
            throw new UsernameNotFoundException("User: " + username + " was not found in the database");
        }

        // Find its Role [i.e. USER,ADMIN,..]
        String role= userService.findUserRoleByPrivilegeId(targetUser.getUserPrivilege().getId());

        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
        // If it has any Role assigned
        if(role!= null)  {
            logger.trace("Role found: "+role);
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
            // Add to Principal's permission
            grantList.add(authority);
        }

        // Return to create instance of Principal/User that implements default UserDetails
        /*TODO: check if normal login works otherwise implement separate SocialDetails & Service class*/
        return (UserDetails) new User(targetUser.getUserName(), //
                targetUser.getUserPassword(),grantList);
        /*return *//*(SocialUserDetails)*//* new SocialUser(targetUser.getUserName(), targetUser.getUserPassword(), grantList);*/
    }

    /* Here, username is stored on both User, User_Roles table
    ;  A user is considered to have many role thus used List
    ;  Role is retrieved by username

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoDAO.findUserInfo(username);
        System.out.println("UserInfo= " + userInfo);

        if (userInfo == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        // [USER,ADMIN,..]
        List<String> roles= userInfoDAO.findUserRoleByPrivilegeId(username);

        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
        if(roles!= null)  {
            for(String role: roles)  {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(userInfo.getUserName(), //
                userInfo.getPassWord(),grantList);

        return userDetails;
    }*/

}