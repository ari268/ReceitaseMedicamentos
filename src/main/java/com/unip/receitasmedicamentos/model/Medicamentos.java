package com.unip.receitasmedicamentos.model;


import jakarta.persistence.*;

@Entity
public class Medicamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String dosagem;

    @ManyToOne
    @JoinColumn(name = "receita_id")
    private Receita receita;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDosagem() { return dosagem; }
    public void setDosagem(String dosagem) { this.dosagem = dosagem; }

    public Receita getReceita() { return receita; }
    public void setReceita(Receita receita) { this.receita = receita; }
}
