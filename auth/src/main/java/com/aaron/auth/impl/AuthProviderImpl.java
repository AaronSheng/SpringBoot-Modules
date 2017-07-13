package com.aaron.auth.impl;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by com.aaron on 7/13/17.
 */
public class AuthProviderImpl extends AbstractUserDetailsAuthenticationProvider {
    private UserDetailsService userDetailsService = new UserDetailServiceImpl();

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        System.out.println("additionalAuthenticationChecks");
    }

    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        return userDetailsService.loadUserByUsername(s);
    }
}
