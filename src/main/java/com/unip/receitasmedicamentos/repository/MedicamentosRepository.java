package com.unip.receitasmedicamentos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.unip.receitasmedicamentos.model.Medicamentos;

public interface MedicamentosRepository extends JpaRepository<Medicamentos, Long> {
}
