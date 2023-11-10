package com.ifes.dwIntegracao.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifes.dwIntegracao.application.HistoriaUsuarioApplication;
import com.ifes.dwIntegracao.dto.HistoriaUsuarioDTO;
import com.ifes.dwIntegracao.exception.NotFoundException;
import com.ifes.dwIntegracao.model.HistoriaUsuario;

@RestController
@RequestMapping("Historia de Usuario")

public class HistoriaUsuarioController {

    private HistoriaUsuarioApplication application;

    @PostMapping("Gerar/{id}")
    public List<HistoriaUsuario> gerar(@PathVariable int id){
        return null;
    }
    
    @GetMapping("Pesquisar/{id}")
    public HistoriaUsuario getById(@PathVariable int id){
        try {
            return application.getById(id);

        } catch (NotFoundException e) {
            e.getMessage();
        }
        return null;

    }

    @GetMapping("Listar/")
    public List<HistoriaUsuario> getAll(){
        return application.getAll();
    }

    @PutMapping("Atualizar/")
    public void update(@PathVariable int id, @RequestBody HistoriaUsuarioDTO dto){
        application.update(dto, id);

    }

    @DeleteMapping("deletar/{id}")
    public void delete(@PathVariable int id){
        application.delete(id);
    }
}
