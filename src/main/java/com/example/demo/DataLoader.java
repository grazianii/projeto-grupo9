package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.demo.entity.Categoria;
import com.example.demo.entity.Receita;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.ReceitaRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoriaRepository categoriaRepository;
    private final ReceitaRepository receitaRepository;

    public DataLoader(CategoriaRepository categoriaRepository, ReceitaRepository receitaRepository) {
        this.categoriaRepository = categoriaRepository;
        this.receitaRepository = receitaRepository;
    }

    @Override
    public void run(String... args) {
        Categoria sobremesa = categoriaRepository.save(new Categoria("Sobremesa"));
        Categoria pratoPrincipal = categoriaRepository.save(new Categoria("Prato Principal"));
        Categoria vegetariano = categoriaRepository.save(new Categoria("Vegetariano"));
    
        Receita boloChocolate = new Receita(
            "Bolo de Chocolate", 
            "Um delicioso bolo de chocolate com cobertura cremosa.",
            "2 xícaras de farinha, 1 xícara de açúcar, 1 xícara de chocolate em pó, 4 ovos, 1 xícara de leite, 1 colher de fermento",
            "Misture os ingredientes secos, adicione os líquidos e asse por 40 minutos a 180°C.",
            sobremesa
        );
    
        Receita feijoada = new Receita(
            "Feijoada",
            "Um prato tradicional brasileiro, rico e saboroso.",
            "1 kg de feijão preto, 500 g de carne seca, 300 g de costela, 200 g de linguiça, folhas de louro, alho, cebola",
            "Cozinhe o feijão com as carnes e temperos até ficar macio.",
            pratoPrincipal
        );
    
        receitaRepository.save(boloChocolate);
        receitaRepository.save(feijoada);
    }
}