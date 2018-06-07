package pkg.spring.basic.dto;

import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.UserProfile;

import java.util.UUID;

/*
* Data Transfer Object
* */
@Data
public class RegistrationForm {

    @Autowired
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) // exclude this field from Lombok
    Logger logger;

    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String passwordVerification;
    //private String role;

    private String signInProvider;
    private String providerUserId;

    public RegistrationForm(){
        logger = LoggerFactory.getLogger(this.getClass());
    }

    public RegistrationForm(Connection<?> connection){
        logger = LoggerFactory.getLogger(this.getClass());
        logger.trace("Retrieving data of the attempted social user");

        // get attempt user information from connection session
        UserProfile socialUserProfile = connection.fetchUserProfile();

        this.id = UUID.randomUUID().toString();
        this.email = socialUserProfile.getEmail();
        this.userName = socialUserProfile.getUsername();
        this.firstName = socialUserProfile.getFirstName();
        this.lastName = socialUserProfile.getLastName();


        ConnectionKey connectionKey = connection.getKey();
        // e.g google, facebook, twitter
        this.signInProvider = connectionKey.getProviderId();
        // ID of the provider e.g. facebook
        this.providerUserId = connectionKey.getProviderUserId();
        logger.trace("Finished form initialization for {} ; Provider: {} ; UserId: {}", socialUserProfile.getName(), signInProvider, providerUserId);
    }
}
