package pkg.spring.basic.model.auth;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "User_Privilege")
@Data
public class UserPrivilege {
    @Id
    @GeneratedValue
    @Column(name = "privilegeID")
    private Long id;

    @Column(nullable = false)
    private String privilegeType;
}