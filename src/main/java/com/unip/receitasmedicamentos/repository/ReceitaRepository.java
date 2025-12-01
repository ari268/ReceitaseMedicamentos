package com.unip.receitasmedicamentos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.unip.receitasmedicamentos.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}
