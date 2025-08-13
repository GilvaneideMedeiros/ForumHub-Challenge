package com.gilvaneide.forumHub.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable()) // Desabilita CSRF, comum em APIs stateless
                .authorizeHttpRequests(req -> {
                    req.requestMatchers("/topicos").permitAll(); // Permite acesso público à rota /hello
                    req.anyRequest().authenticated(); // Exige autenticação para todas as outras rotas
                })
                .build();
    }
}
