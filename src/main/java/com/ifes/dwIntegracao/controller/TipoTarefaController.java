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

import com.ifes.dwIntegracao.application.TipoTarefaApplication;
import com.ifes.dwIntegracao.dto.TipoTarefaDTO;
import com.ifes.dwIntegracao.exception.NotFoundException;
import com.ifes.dwIntegracao.model.TipoTarefa;

@RequestMapping("cadastrar")
@RestController
public class TipoTarefaController {
    @Autowired
    TipoTarefaApplication application;

    @PostMapping("Criar/")
    public TipoTarefa create(@RequestBody TipoTarefaDTO tipoTarefaDTO){
        return application.create(tipoTarefaDTO);
    }

    @GetMapping("Pesquisar/{id}")
    public TipoTarefa getById(@PathVariable int id) throws NotFoundException {
        return application.getById(id);
    }

    @GetMapping("Listar/")
    public List<TipoTarefa> listar(){
        return application.getAll();
    }

    @PutMapping("Atualizar/{id}")
    public void update(@PathVariable int id, @RequestBody TipoTarefaDTO tipoTarefaDTO){
        application.update(id, tipoTarefaDTO);
    }

    @DeleteMapping("Excluir/{id}")
    public void delete(@PathVariable int id){
        application.delete(id);
    }

    
}
