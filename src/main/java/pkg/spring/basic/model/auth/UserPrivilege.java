package pkg.spring.basic.model.auth;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "User_Privilege")
@Data
public class UserPrivilege {
    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name = "privilegeID", updatable = false)
    private Long id;

    @Column(updatable = false, nullable = false)
    private String privilegeType;
}