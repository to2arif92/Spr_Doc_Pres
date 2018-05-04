package pkg.spring.basic.dto;

import lombok.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.UserProfile;
/*
* Data Transfer Object
* */
@Data @NoArgsConstructor
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


    public RegistrationForm(Connection<?> connection){
        // get authorized user information?
        UserProfile socialUserProfile = connection.fetchUserProfile();
        //logger.trace("Authorized user: {}", socialUserProfile);

        this.id = socialUserProfile.getId();
        this.email = socialUserProfile.getEmail();
        this.userName = socialUserProfile.getUsername();
        this.firstName = socialUserProfile.getFirstName();
        this.lastName = socialUserProfile.getLastName();


        ConnectionKey connectionKey = connection.getKey();
        // e.g google, facebook, twitter
        this.signInProvider = connectionKey.getProviderId();
        // ID of the provider e.g. facebook
        this.providerUserId = connectionKey.getProviderUserId();
        //logger.trace("Initializing form with {} ; Provider: {} ; UserId: {}", socialUserProfile, signInProvider, providerUserId);
    }
}
