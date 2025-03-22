package com.login.springsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.springsecurity.models.AppUser;


public interface AppUserRepositorio extends JpaRepository<AppUser, Long>{
    //Definindo um método para encontrar pelo email
    public AppUser findByEmail(String email);
}
