package com.ifes.dwIntegracao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ifes.dwIntegracao.application.TipoHistoriaUsuarioApplication;
import com.ifes.dwIntegracao.dto.TipoHistoriaUsuarioDTO;
import com.ifes.dwIntegracao.exception.NotFoundException;
import com.ifes.dwIntegracao.model.TipoHistoriaUsuario;





@RestController
@RequestMapping("Tipo_Historia_Usuario")
public class TipoHistoriaUsuarioController{
    @Autowired
    TipoHistoriaUsuarioApplication tipoHUApplication;

   @PostMapping("Cadastrar/")
    public TipoHistoriaUsuario create(@RequestBody TipoHistoriaUsuarioDTO tipoHUdto, @PathVariable int id)
    {
        return tipoHUApplication.create(tipoHUdto);
    }

    @GetMapping("Pesquisar/{id}")
    public TipoHistoriaUsuario get(@PathVariable int id)
    {
       
        try{
           return tipoHUApplication.getById(id);
        }
        catch (NotFoundException e){
            e.getMessage();
        }

        return null;
    }

    @GetMapping("Listar/")
    public List<TipoHistoriaUsuario> getAll(){
        return tipoHUApplication.getAll();
    }

    @PutMapping("Atualizar/{id}")
    public void update (@PathVariable int id, @RequestBody TipoHistoriaUsuarioDTO tipoHUdto){
        tipoHUApplication.update(id, tipoHUdto);
    }

    @DeleteMapping("Deletar/{id}")
    public void delete(@PathVariable int id)
    {
        tipoHUApplication.delete(id);
    }
}