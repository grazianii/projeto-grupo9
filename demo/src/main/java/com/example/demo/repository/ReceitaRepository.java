package com.example.demo.repository;

import com.example.demo.entity.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    List<Receita> findByCategoriaId(Long categoriaId);
}
