package com.ifes.dwIntegracao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifes.dwIntegracao.application.ProjetoApplication;
import com.ifes.dwIntegracao.dto.ProjetoDTO;
import com.ifes.dwIntegracao.dto.TipoEpicoDTO;
import com.ifes.dwIntegracao.model.Projeto;
import com.ifes.dwIntegracao.model.TipoEpico;


@RestController
@RequestMapping("projeto")
public class ProjetoController{
    @Autowired
    ProjetoApplication projetoApplication;

   @PostMapping("/")
    public Projeto create(@RequestBody ProjetoDTO projetoDto)
    {
        return projetoApplication.create(projetoDto);
    }
    
}
