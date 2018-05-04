package pkg.spring.basic.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import pkg.spring.basic.model.auth.User;

public class SecurityUtil {
    // Auto login
    public static void logInUser(User user){

        System.out.println("Auto login Social");
        MySocialUserDetails userDetails = new MySocialUserDetails(user); // custom SocialUserDetails

        //SocialUserDetails userDetails = new SocialUserDetails();

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
