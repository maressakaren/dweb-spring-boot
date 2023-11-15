package com.ifes.dwIntegracao.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifes.dwIntegracao.application.TarefaApplication;
import com.ifes.dwIntegracao.dto.TarefaDTO;
import com.ifes.dwIntegracao.exception.NotFoundException;
import com.ifes.dwIntegracao.model.Tarefa;

@RestController
@RequestMapping("/TarefaBD")

public class TarefaController {

    @Autowired
    private TarefaApplication application;

    @PostMapping("Gerar/{id}")
    public List<Tarefa> gerar(@PathVariable int id){
        return application.gera(id);
    }
    
    @GetMapping("Pesquisar/{id}")
    public Tarefa getById(@PathVariable int id){
        try {
            return application.getById(id);

        } catch (NotFoundException e) {
            e.getMessage();
        }
        return null;

    }

    @GetMapping("Listar/")
    public List<Tarefa> getAll(){
        return application.getAll();
    }

    @PutMapping("Atualizar/")
    public void update(@PathVariable int id, @RequestBody TarefaDTO dto){
        application.update(dto, id);

    }

    @DeleteMapping("deletar/{id}")
    public void delete(@PathVariable int id){
        application.delete(id);
    }
}
