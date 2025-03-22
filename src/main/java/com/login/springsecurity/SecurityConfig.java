package com.login.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/contato", "/register", "/login", "/logout").permitAll()
                        .anyRequest().authenticated())

                .formLogin(form -> form.defaultSuccessUrl("/", true))

                .logout(config -> config.logoutSuccessUrl("/login"))

                .build();
    }

}
