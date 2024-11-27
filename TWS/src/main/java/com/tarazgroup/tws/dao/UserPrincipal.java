package com.tarazgroup.tws.dao;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * <p>custom implementation of {@link UserDetails} </p>
 *
 * @author alireza_bayat
 * @see org.springframework.security.core.userdetails.UserDetails
 * @since 2.0.0
 */
public class UserPrincipal implements UserDetails {
    final BigDecimal userID;
    final String androidUserPass;
    final boolean isActive;


    public UserPrincipal(BigDecimal userID , String androidUserPass, boolean isActive) {
        this.userID = userID;
        this.androidUserPass = androidUserPass;
        this.isActive = isActive;
    }


    //set proper Granted authority collection
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public BigDecimal getUserID() {
        return userID;
    }

    @Override
    public String getPassword() {
        return androidUserPass;
    }

    @Override
    public String getUsername() {
        return androidUserPass;
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
        return isActive;
    }
}
