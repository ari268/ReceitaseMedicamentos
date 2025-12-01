package com.unip.receitasmedicamentos.controller;


import com.unip.receitasmedicamentos.model.Receita;
import com.unip.receitasmedicamentos.repository.ReceitaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/receitas")
public class ReceitaController {
    private final ReceitaRepository receitaRepository;

    public ReceitaController(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("receitas", receitaRepository.findAll());
        return "receitas";
    }

    @GetMapping("/nova")
    public String nova(Model model) {
        model.addAttribute("receita", new Receita());
        return "form-receita";
    }

    @PostMapping
    public String salvar(@ModelAttribute Receita receita) {
        receitaRepository.save(receita);
        return "redirect:/receitas";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        receitaRepository.deleteById(id);
        return "redirect:/receitas";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Receita receita = receitaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Receita inválida"));
        model.addAttribute("receita", receita);
        return "form-receita";
    }

}
