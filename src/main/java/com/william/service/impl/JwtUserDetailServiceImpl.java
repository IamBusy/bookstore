package com.william.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by william on 17/3/3.
 */
public class JwtUserDetailServiceImpl implements UserDetailsService{



    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        return null;
//        Users users = userRepository.findByPhone(username);
//        return new JwtUser(
//                users.getId(),
//                users.getPhone(),
//                users.getPassword(),
//                new SimpleGrantedAuthority("USER"),
//                true
//        );
    }
}
