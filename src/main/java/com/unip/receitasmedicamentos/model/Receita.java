package com.unip.receitasmedicamentos.model;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paciente;
    private String descricao;

    @OneToMany(mappedBy = "receita", cascade = CascadeType.ALL)
    private List<Medicamentos> medicamentos;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPaciente() { return paciente; }
    public void setPaciente(String paciente) { this.paciente = paciente; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public List<Medicamentos> getMedicamentos() { return medicamentos; }
    public void setMedicamentos(List<Medicamentos> medicamentos) { this.medicamentos = medicamentos; }
}
