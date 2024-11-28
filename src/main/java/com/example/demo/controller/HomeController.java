package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Classe criada somente para teste de API, indicando que é possível acessar algum end point

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Bem-vindo à aplicação!";
    }

    @GetMapping("/public/test")
    public String publicPage() {
        return "Esta é uma página pública.";
    }
}
