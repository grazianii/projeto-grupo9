package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @Lob
    private String ingredientes;

    @Lob
    private String modoPreparo;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
