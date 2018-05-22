package pkg.spring.basic.config;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;
import pkg.spring.basic.service.UserService;
import pkg.spring.basic.signup.AutoSocialSignUp;

import javax.sql.DataSource;

@Configuration
@EnableSocial
// load to Environment
@PropertySource("classpath:social-cfg.properties")
public class SocialConfig implements SocialConfigurer{

    private boolean autoSignUp = false;

    @Autowired
    Logger logger;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserService userService;

    /**
     * Configures the connection factories for Facebook and Twitter.
     * @param cfConfig
     * @param env
     */
    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment env) {
        logger.trace("Getting social account settings from properties file");
        /* Facebook */
        FacebookConnectionFactory fbConnectionFactory = new FacebookConnectionFactory(
                env.getProperty("facebook.app.id"),
                env.getProperty("facebook.app.secret")
        );
        fbConnectionFactory.setScope(env.getProperty("facebook.scope"));
        cfConfig.addConnectionFactory(fbConnectionFactory);
        logger.trace("Facebook configured?");

        /* Google */
        GoogleConnectionFactory gfactory = new GoogleConnectionFactory(
                env.getProperty("google.client.id"),
                env.getProperty("google.client.secret")
        );
        gfactory.setScope(env.getProperty("google.scope"));
        cfConfig.addConnectionFactory(gfactory);
        logger.trace("Google configured?");
    }

    // The UserIdSource determines the userID of the user
    @Override
    public UserIdSource getUserIdSource() {
        return new AuthenticationNameUserIdSource();
    }

    // Read and insert to UserConnection table
    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {

        logger.trace("Auto sign-up is: {}", autoSignUp);
        // org.springframework.social.security.SocialAuthenticationServiceRegistry
        JdbcUsersConnectionRepository jdbcUsersConnectionRepository = new JdbcUsersConnectionRepository(
                dataSource, connectionFactoryLocator, Encryptors.noOpText()
        );

        if(autoSignUp){

            /*Config to:
            * After login to Social > Automatically create corresponding User, if no user id could be mapped from a Connection(social) */
            logger.trace("Trying to auto create account");
            ConnectionSignUp connectionSignUp = new AutoSocialSignUp(userService);
            //connectionSignUp.execute();
            jdbcUsersConnectionRepository.setConnectionSignUp(connectionSignUp);
        } else {
            /*Config to:
            * After login to Social > If User doesn't exists, Redirect to sign up page*/
            logger.trace("Forwarding the social user:  to signup page");
            jdbcUsersConnectionRepository.setConnectionSignUp(null);
        }

        return jdbcUsersConnectionRepository;
    }

    // This bean manages the connection flow between the account provider and the this application.
    @Bean
    public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository){
        return new ConnectController(connectionFactoryLocator, connectionRepository);
    }
}
