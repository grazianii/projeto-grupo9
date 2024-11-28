package com.example.demo.controller;


import com.example.demo.entity.Receita;
import com.example.demo.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaRepository receitaRepository;

    @GetMapping
    public List<Receita> getAllReceitas() {
        return receitaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> getCategoriaById(@PathVariable Long id) {
        return receitaRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Receita createReceita(@RequestBody Receita receita) {
        return receitaRepository.save(receita);
    }

    @PutMapping("/{id}")
    public Receita updateReceita(@PathVariable Long id, @RequestBody Receita receitaDetails) {
        Receita receita = receitaRepository.findById(id).orElseThrow();
        receita.setNome(receitaDetails.getNome());
        receita.setDescricao(receitaDetails.getDescricao());
        receita.setIngredientes(receitaDetails.getIngredientes());
        receita.setModoPreparo(receitaDetails.getModoPreparo());
        receita.setCategoria(receitaDetails.getCategoria());
        return receitaRepository.save(receita);
    }

    @DeleteMapping("/{id}")
    public void deleteReceita(@PathVariable Long id) {
        receitaRepository.deleteById(id);
    }
}
