package com.codegym.teluscospringsecurity.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserPrincipal implements UserDetails {

    private static final long serialVersionUID = 1L;

    private int id;

    private String username;

    private String password;

    private Collection<? extends GrantedAuthority> roles;

    public UserPrincipal(int id,
                         String username, String password,
                         Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public static UserPrincipal build(Users user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Roles a: user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(a.getName()));
        }

        return new UserPrincipal(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }
    public int getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPrincipal user = (UserPrincipal) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
