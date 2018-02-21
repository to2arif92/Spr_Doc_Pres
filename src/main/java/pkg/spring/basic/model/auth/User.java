package pkg.spring.basic.model.auth;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JoinFormula;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

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

    //@Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) // exclude this field from Lombok
    @ManyToOne/*(fetch = FetchType.LAZY)*/
    @JoinColumn(name = "privilegeID", nullable = false, columnDefinition = "bigint default 2")  // bigint = long; 2= user/normal privilege
    @ColumnDefault("bigint default 2")
    private UserPrivilege userPrivilege;
}
