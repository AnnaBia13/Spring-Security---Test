package com.login.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.login.springsecurity.models.AppUser;
import com.login.springsecurity.models.AppUserDto;
import com.login.springsecurity.repositories.AppUserRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppUserController {

    @Autowired
    private AppUserRepositorio repo;

    @GetMapping("/register")
    public String register(Model model) {
        AppUserDto dto = new AppUserDto();
        model.addAttribute("dto", dto);

        return "register";
    }
    
    @PostMapping("/register")
    public String saveRegister(Model model, @ModelAttribute AppUserDto dto, BindingResult result) {
        
        if (!dto.getSenha().equals(dto.getConfirmarSenha())) {
            result.addError(
                new FieldError("dto", "confirmarSenha", "Senhas não são iguais.")  
            );
        }

        //Conferir se o email ja existe
        AppUser appUser = repo.findByEmail(dto.getEmail());
        if (appUser != null) {
            result.addError(
                new FieldError("dto", "email", "Endereço de email já cadastrado")
            );
        }

        if (result.hasErrors()) {
            return "register";
        }

        return "sucesso";
    }
    
}
