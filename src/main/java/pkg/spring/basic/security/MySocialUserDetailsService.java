package pkg.spring.basic.security;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pkg.spring.basic.model.auth.User;
import pkg.spring.basic.service.UserService;

@Service
@Transactional
public class MySocialUserDetailsService implements SocialUserDetailsService {
/* remove DAO & use service
    @Autowired
    private UserService userService;*/
    @Autowired
    private UserService userService;

    @Autowired
    Logger logger;
    /**
     * Loads the username by using the account ID of the user.
     * @param userId The account ID of the requested user.
     * @return The information of the requested user.
     * @throws UsernameNotFoundException    Thrown if no user is found.
     */
    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        //System.out.println("MySocialUserDetailsService");
        User user = null;
        try {
            user = userService.findUserById(userId);
            logger.debug("Social user found on DB: {}", user.getId());
        } catch (Exception e){
            logger.error("Social user with id:{} is not found in the database", userId);
        }
        MySocialUserDetails userDetails = new MySocialUserDetails(user);
        return userDetails;
    }
}
