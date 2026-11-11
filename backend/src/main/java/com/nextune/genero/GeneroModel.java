package com.nextune.genero;

import jakarta.persistence.*;

@Entity
@Table(name = "genero")
public class GeneroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80, unique = true)
    private String nome;

    protected GeneroModel() {}

    public GeneroModel(String nome) {
        this.nome = nome;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }
}