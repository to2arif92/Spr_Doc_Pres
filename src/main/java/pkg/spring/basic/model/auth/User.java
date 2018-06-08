package pkg.spring.basic.model.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by ArIF on 10-Jun-17.
 */

@Entity
@Table(name = "User")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @NotBlank
    @Id
    @Column(nullable = false, unique = true)
    private String userName;

    /*@NotBlank
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column
    private long Serial;*/
    //@Id
    @Column(updatable = false, /*nullable = false, */unique = true)
    private String id = UUID.randomUUID().toString();

    @NotBlank   // not Null or Empty
    @Column(nullable = false)
    private String userPassword;

    private String firstName;
    private String lastName;

    @NotBlank @Email
    @Column(length = 100, unique = true)
    private String email;

    @ColumnDefault("true")
    private boolean loginStatus = true;   // by setting false it means, its default value is false/0 if not overwritten

    @CreationTimestamp
    //@Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    @ColumnDefault("CURRENT_TIMESTAMP")
    private LocalDateTime regDate;

    //@Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(columnDefinition = "DATETIME ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime lastSigned;

    /* TODO: Only privilege with ADMIN or OWNER, can modify privilege ; HINT: set limit/range, Spring Security */
    /*
       commented out along with referencedColumnName, so that there stays no option to set privilege e.g. ADMIN other than the default one i.e USER

       if used, userModel.getUserPrivilege().getId() should be replace by userModel.getUserPrivilege()
    */
    //private long privilegeID = 2;

    //@Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) // commented out as getter is needed in MyDBAuthenticationService to get Role based on ID
    @ManyToOne(fetch = FetchType.EAGER)
    // bigint = long; 2= user/normal privilege; referencedColumnName points to the column in this Entity(User) which ultimately helps to update or insert value e.g. 1
    @JoinColumn(name = "privilegeID", /*referencedColumnName = "privilegeID",*/ insertable = false, updatable = false, nullable = false, columnDefinition = "bigint default 2")
    private UserPrivilege userPrivilege;
}
