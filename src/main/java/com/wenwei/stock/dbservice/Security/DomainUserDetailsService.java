package com.wenwei.stock.dbservice.Security;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * author:zhou_wenwei
 * mail:
 * date:2017/12/25
 * description:
// */
public class DomainUserDetailsService implements  UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
