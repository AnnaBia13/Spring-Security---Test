package com.login.springsecurity.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppUserDto {

    @NotEmpty
    private String primeiroNome;

    @NotEmpty
    private String ultimoNome;

    @NotEmpty
    @Email
    private String email;

    @Size(min = 9, message = "O telefone deve conter no mínimo 9 números.")
    private int telefone;

    @NotEmpty
    @Size(min = 8, message = "A senha deve conter no mínimo 8 caracteres.")
    private String senha;

    @NotEmpty
    @Size(min = 8, message = "A senha deve conter no mínimo 8 caracteres.")
    private String confirmarSenha;

    private String endereco;
}
