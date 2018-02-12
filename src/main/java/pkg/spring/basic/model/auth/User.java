package pkg.spring.basic.model.auth;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ArIF on 10-Jun-17.
 */

@Entity
@Table(name = "User")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    /*public User(String userName, String userPassword){
        this.userName = userName;
        this.userPassword = userPassword;
    }*/

    @Id
    private String userName;

    @Column(nullable = false)
    private String userPassword;

    private boolean userStatus;

    private Date regDate;

    private Date lastSigned;

    //@Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) // exclude this field from Lombok
    @ManyToOne/*(fetch = FetchType.LAZY)*/
    @JoinColumn(name = "privilegeID")
    private UserPrivilege userPrivilege;
}
