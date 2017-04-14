package pkg.spring.basic.model;

import org.springframework.context.annotation.Bean;

/**
 * Created by ArIF on 14-Apr-17.
 */

public class UserInfo {
    private String userName;
    private String passWord;

    public UserInfo(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
