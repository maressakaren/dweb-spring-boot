package com.ifes.dwIntegracao.controller;

import com.ifes.dwIntegracao.application.TipoEpicoApplication;
import com.ifes.dwIntegracao.dto.TipoEpicoDTO;
import com.ifes.dwIntegracao.exception.NotFoundException;
import com.ifes.dwIntegracao.model.TipoEpico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cadastro_tipo_epico")
public class TipoEpicoController
{
    @Autowired
    TipoEpicoApplication tipoEpicoApplication;

    @PostMapping("criar")
    public TipoEpico create(@RequestBody TipoEpicoDTO tipoEpicoDTO)
    {
        return tipoEpicoApplication.create(tipoEpicoDTO);
    }

    @GetMapping("pegar/{id}")
    public TipoEpico get(@PathVariable int id)
    {
        TipoEpico tipoEpico;

        try
        {
           return tipoEpicoApplication.retrieve(id);
        }
        catch (NotFoundException e)
        {
            e.getMessage();
        }

        return null;
    }

    @GetMapping("pegar_todos")
    public List<TipoEpico> getAll()
    {
        return tipoEpicoApplication.retrieveAll();
    }

    @PutMapping("atualizar/{id}")
    public void update (@PathVariable int id, @RequestBody TipoEpicoDTO tipoEpicoDTO)
    {
        tipoEpicoApplication.update(id, tipoEpicoDTO);
    }

    @DeleteMapping("deletar/{id}")
    public void delete(@PathVariable int id)
    {
        tipoEpicoApplication.delete(id);
    }
}