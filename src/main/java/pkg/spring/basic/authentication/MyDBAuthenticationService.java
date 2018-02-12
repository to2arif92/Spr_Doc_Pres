package pkg.spring.basic.authentication;

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

/**
 * Created by ArIF on 14-Apr-17.
 */
@Service
public class MyDBAuthenticationService implements UserDetailsService {

    @Autowired
    private Logger logger;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        pkg.spring.basic.model.auth.User userModel = userService.getUser(username);
        //System.out.println("User= " + userModel);


        if (userModel == null) {
            logger.warn("User not found by username: "+username);
            throw new UsernameNotFoundException("User: " + username + " was not found in the database");
        }

        // [USER,ADMIN,..]
        String role= userService.getUserRole(userModel.getUserPrivilege().getId());

        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
        if(role!= null)  {
            logger.trace("Role found: "+role);
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
            grantList.add(authority);
        }

        return (UserDetails) new User(userModel.getUserName(), //
                userModel.getUserPassword(),grantList);
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
        List<String> roles= userInfoDAO.getUserRole(username);

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