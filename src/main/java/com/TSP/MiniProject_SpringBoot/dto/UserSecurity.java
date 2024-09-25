package com.TSP.MiniProject_SpringBoot.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserSecurity extends User {
    private static final long serialVersionUID = 1L;



    public UserSecurity(String username, String password, boolean enabled, boolean accountNonExpired,
                        boolean credentialsNonExpired, boolean accountNonLocked,
                        Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        // TODO Auto-generated constructor stub
    }

    public UserSecurity(Long id, String email, String password, String fullName, String code, boolean enabled, boolean accountNonExpired,
                        boolean credentialsNonExpired, boolean accountNonLocked,
                        Collection<? extends GrantedAuthority> authorities) {
        super(email, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.fullName = fullName;
        this.code = code;
        this.id = id;
    }

    private Long id;
    private String fullName;
    private String code;
}
