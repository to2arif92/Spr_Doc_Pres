package pkg.spring.basic.model.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * Created by ArIF on 10-Jun-17.
 */

@Entity
@Table(name = "User")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @Column(updatable = false, nullable = false)
    private String userName;

    @NotBlank   // not Null or Empty
    @Column(nullable = false)
    private String userPassword;

    @ColumnDefault("true")
    private boolean loginStatus = true;   // by setting false it means, its default value is false/0 if not overwritten

    @CreationTimestamp
    private LocalDateTime regDate;

    //@Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private LocalDateTime lastSigned;

    /* TODO: Only privilege with ADMIN or OWNER, can modify privilege ; HINT: set limit/range, Spring Security */
    /*
       commented out along with referencedColumnName, so that there stays no option to set privilege e.g. ADMIN other than the default one i.e USER
    */
    //private long privilegeID = 2;

    //@Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) // commented out as getter is needed in MyDBAuthenticationService to get Role based on ID
    @ManyToOne/*(fetch = FetchType.LAZY)*/
    // bigint = long; 2= user/normal privilege; referencedColumnName points to the column in this Entity(User) which ultimately helps to update or insert value e.g. 1
    @JoinColumn(name = "privilegeID", /*referencedColumnName = "privilegeID",*/ insertable = false, updatable = false, nullable = false, columnDefinition = "bigint default 2")
    private UserPrivilege userPrivilege;
}
