package com.unip.receitasmedicamentos.controller;

import com.unip.receitasmedicamentos.model.Medicamentos;
import com.unip.receitasmedicamentos.repository.MedicamentosRepository;
import com.unip.receitasmedicamentos.repository.ReceitaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/medicamentos")
public class MedicamentosController {

    private final MedicamentosRepository medicamentoRepository;
    private final ReceitaRepository receitaRepository;

    public MedicamentosController(MedicamentosRepository medicamentoRepository, ReceitaRepository receitaRepository) {
        this.medicamentoRepository = medicamentoRepository;
        this.receitaRepository = receitaRepository;
    }


    @GetMapping
    public String listar(Model model) {
        model.addAttribute("medicamentos", medicamentoRepository.findAll());
        return "medicamentos";
    }

 
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("medicamento", new Medicamentos());
        model.addAttribute("receitas", receitaRepository.findAll());
        return "form-medicamento";
    }

    @PostMapping
    public String salvar(@ModelAttribute Medicamentos medicamento) {
        medicamentoRepository.save(medicamento);
        return "redirect:/medicamentos";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        medicamentoRepository.deleteById(id);
        return "redirect:/medicamentos";
    }

    
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Medicamentos medicamento = medicamentoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Medicamento inválido"));
        model.addAttribute("medicamento", medicamento);
        model.addAttribute("receitas", receitaRepository.findAll());
        return "form-medicamento";
    }
}
