package pkg.spring.basic.model.auth;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ArIF on 10-Jun-17.
 */

@Entity
@Table(name = "User")
@Data
public class User {

    @Id
    private String userName;

    @Column(nullable = false)
    private String userPassword;

    private boolean userStatus;

    private Date regDate;

    private Date lastSigned;

    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) // exclude this field from Lombok
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "privilegeID")
    private UserPrivilege userPrivilege;
}
