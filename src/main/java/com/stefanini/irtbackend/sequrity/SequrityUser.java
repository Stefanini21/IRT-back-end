package com.stefanini.irtbackend.sequrity;

import com.stefanini.irtbackend.enums.UserStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

public class SequrityUser implements UserDetails {

    private final String userName;
    private final String password;
    private final List<SimpleGrantedAuthority> authorities;
    private final boolean isActive;

    public SequrityUser(String userName, String password, List<SimpleGrantedAuthority> authorities, boolean isActive) {
        this.userName = userName;
        this.password = password;
        this.authorities = authorities;
        this.isActive = isActive;
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
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public static UserDetails fromUser(com.stefanini.irtbackend.entity.User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(),
                user.getUserStatus().equals(UserStatus.ACTIVE),
                user.getUserStatus().equals(UserStatus.ACTIVE),
                user.getUserStatus().equals(UserStatus.ACTIVE),
                user.getUserStatus().equals(UserStatus.ACTIVE),
                user.getRole().getAuthorities()
        );
    }
}