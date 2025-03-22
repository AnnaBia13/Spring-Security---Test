package com.login.springsecurity.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceLogin implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws 
    UsernameNotFoundException{
        if("admin".equals(username)){
            return User.withUsername("admin")
                .password("{noop}1234")
                .roles("ADMIN")
                .build();
        }throw new UsernameNotFoundException("Usuário não encontrado" + username);

    }

}
