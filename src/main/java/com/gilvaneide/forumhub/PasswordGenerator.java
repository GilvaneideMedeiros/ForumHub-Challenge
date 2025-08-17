package com.gilvaneide.forumhub;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "123456"; // Coloque a senha que você quer criptografar aqui
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println("Senha em texto puro: " + rawPassword);
        System.out.println("Senha criptografada (para o banco): " + encodedPassword);
    }
}