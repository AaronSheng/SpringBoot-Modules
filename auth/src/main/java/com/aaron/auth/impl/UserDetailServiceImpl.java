package com.aaron.auth.impl;

import com.aaron.auth.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

/**
 * Created by aaron on 7/13/17.
 */
public class UserDetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new UserDetails("hello", "world", new ArrayList<GrantedAuthority>(1));
    }
}
