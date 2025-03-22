package com.login.springsecurity.models;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "users")
public class AppUser {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String primeiroNome;
    private String ultimoNome;

    @Column (unique = true, nullable = false)
    private String email;
    
    private int telefone;
    private String endereco;
    private String senha;
    private Date criadoEm;
    private String papel;
}
