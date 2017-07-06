package pkg.spring.basic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by ArIF on 10-Jun-17.
 */

@Entity
@Table(name = "User_Table")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "U_ID")
    private Long id;
    private String userPassword;
    private String userName;
    private boolean userStatus;
    private String userDisplayName;

    private Date userRegistered;

    public User() {
    }

    public User(String userPassword, String userName, Date userRegistered, boolean userStatus, String userDisplayName) {
        this.userPassword = userPassword;
        this.userName = userName;
        this.userRegistered = userRegistered;
        this.userStatus = userStatus;
        this.userDisplayName = userDisplayName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "U_Password")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Column(name = "U_Name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "U_Registered")
    public Date getUserRegistered() {
        return userRegistered;
    }

    public void setUserRegistered(Date userRegistered) {
        this.userRegistered = userRegistered;
    }

    @Column(name = "U_Status")
    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    @Column(name = "U_Display_Name")
    public String getUserDisplayName() {
        return userDisplayName;
    }

    public void setUserDisplayName(String userDisplayName) {
        this.userDisplayName = userDisplayName;
    }
}
