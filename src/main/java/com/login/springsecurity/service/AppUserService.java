// package com.login.springsecurity.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.login.springsecurity.models.AppUser;
// import com.login.springsecurity.repositories.AppUserRepositorio;

// @Service
// public class AppUserService implements UserDetailsService{

//     @Autowired
//     private AppUserRepositorio repo;

//     @Override
//     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        AppUser appUser = repo.findByEmail(email);
//        if (appUser != null) {
//             var springUser = User.withUsername(appUser.getEmail())
//                 .password(appUser.getSenha())
//                 .roles(appUser.getPapel())
//                 .build();
//             return springUser;
//        }
//        throw new UnsupportedOperationException("Email não encontrado" + email);
//     }
// }
