package pkg.spring.basic.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import pkg.spring.basic.model.auth.User;
import pkg.spring.basic.service.UserService;

public class AutoSocialSignUp implements ConnectionSignUp {

    @Autowired
    private UserService userService;

    public AutoSocialSignUp(UserService userService){
        this.userService = userService;
    }
    @Override
    public String execute(Connection<?> connection) {
        System.out.println("AutoSocialSignUp");
        String username = userService.registerUserFromSocial(connection);
        User registeredUser = userService.findUserByUsername(username);
        return registeredUser.getId();
    }
}
