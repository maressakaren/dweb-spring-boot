package com.ifes.dwIntegracao.controller;

import com.ifes.dwIntegracao.application.EpicoApplication;
import com.ifes.dwIntegracao.dto.EpicoDTO;
import com.ifes.dwIntegracao.exception.NotFoundException;
import com.ifes.dwIntegracao.model.Epico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Epico")
public class EpicoController {
    @Autowired
    private EpicoApplication epicoApplication;

    @PostMapping("novo/{categoriaId}/{projetoId}/{tipoEpicoId}")
    public Epico create(@RequestBody EpicoDTO dto, @PathVariable int categoriaId, @PathVariable int projetoId, @PathVariable int tipoEpicoId) {
        return epicoApplication.create(dto, categoriaId, projetoId, tipoEpicoId);
    }

    @GetMapping("{id}")
    public Epico retrieve(@PathVariable int id) {
        try
        {
            return epicoApplication.retrieve(id);
        } catch (NotFoundException e) {
            e.getMessage();
        }
        return null;
    }

    @GetMapping("todos")
    public List<Epico> retrieveAll()
    {
        return epicoApplication.retrieveAll();
    }

    @PutMapping("atualizar/{id}")
    public Epico update(@PathVariable int id, @RequestBody EpicoDTO epicoDTO)
    {
        return epicoApplication.update(id, epicoDTO);
    }

    @DeleteMapping("remoção/{id}")
    public void delete(@PathVariable int id)
    {
        epicoApplication.delete(id);
    }
}
