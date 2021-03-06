package com.wei.oauth2.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;

/**
 * @author skye
 * @version 1.0
 * @description:
 * @date 2020/11/30 11:17
 */
public class UserModel implements UserDetails {
    private String userName;

    private String password;

    private List<SimpleGrantedAuthority> authorities;

    public UserModel(String userName, String password, List<SimpleGrantedAuthority> authorities) {
        this.userName = userName;
        this.password = new BCryptPasswordEncoder().encode(password);;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
