package pkg.spring.basic.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.transaction.annotation.Transactional;
import pkg.spring.basic.model.auth.User;
import pkg.spring.basic.model.auth.UserPrivilege;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* SocialUserDetails (getUserId) extends UserDetails;
 Provides core/authenticated user information */
@Transactional
public class MySocialUserDetails implements SocialUserDetails {
    //@Autowired
    Logger logger;

    // Unique identifier for a class; Defined here to ensure same(Old/New) class is used during Serialization, is loaded during Deserialization
    private static final long serialVersionUID = 1L;

    private User user;
    private List<GrantedAuthority> grantedAuthorities;

    public MySocialUserDetails(User user) {
        this.user = user;
        logger = LoggerFactory.getLogger(this.getClass());
        logger.debug("Building SocialUserDetails for the authorized user");

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+user.getUserPrivilege().getPrivilegeType());
        grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(authority);
        /* if User has ManyToMany relation with UserPrivilege
        https://github.com/eugenp/tutorials/blob/master/spring-security-mvc-boot/src/main/java/org/baeldung/security/MyUserPrincipal.java

        for (final UserPrivilege privilege: user.getUserPrivilege()){

        }*/
    }

    @Override
    public String getUserId() {
        return this.user.getId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*final List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        *//*
        System.out.println("grantedAuthorities- created");
        *//*UserPrivilege u =user.getUserPrivilege().;
        System.out.println("Privilege:" + u.toString());
        String pr = u.getPrivilegeType();*//*
        grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
        System.out.println("grantedAuthorities- mod");

        return grantedAuthorities;*/
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.user.getUserPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
