#Doctors Prescription
Project description

##Social Account Integration

- To configure social **account credentials**:
`resources/social-cfg.properties` 



- To **turn on** Auto Sign-up feature via Social account:
`java/../config/SocialConfig.java`,

```java
private boolean autoSignUp = true;
```



- To change redirecting **URLs of authentications**: `config/WebSecurityConfig.java`
```java
http.apply(new SpringSocialConfigurer())
                .signupUrl("/signup")
                .postLoginUrl("/userInfo");
```

- To **change privilege** instead of *Role_User* i.e. *Role_Admin*: ``
```java
private User buildUserByForm(RegistrationForm formDTO){
    UserPrivilege privilege = new UserPrivilege();
    privilege.setId(1L); // ADMIN
    user.setUserPrivilege(privilege);
}
``` 


[![Analytics](https://ga-beacon.appspot.com/UA-129757738-3/Spr_Doc_Pres/readme?pixel)](https://github.com/igrigorik/ga-beacon)
