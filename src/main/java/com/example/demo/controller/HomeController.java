package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Bem-vindo ao nosso Portal de Receitas!" + 
        " Para visualizar a lista de receitas, visite o endpoint '/api/receitas'." +
        " Para visualizar a lista de categorias, visite o endpoint '/api/categorias'.";
    }
}