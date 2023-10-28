package com.ifes.dwIntegracao.application;

import com.ifes.dwIntegracao.dto.ProjetoDTO;
import com.ifes.dwIntegracao.exception.NotFoundException;
import com.ifes.dwIntegracao.model.Projeto;
import com.ifes.dwIntegracao.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProjetoApplication
{
    @Autowired
    ProjetoRepository projetoRepository;

    public Projeto create(ProjetoDTO projetoDTO)
    {
        Projeto projeto;

        projeto = new Projeto();
        projeto.setNome(projetoDTO.getNome());

        return projetoRepository.save(projeto);
    }

    public List<Projeto> getAll(){

        return projetoRepository.findAll();
    }
    
    /*public Projeto getById(int id) throws NotFoundException
    {
        Projeto projeto;
        Optional<Projeto> entity;

        entity = projetoRepository.findById(id);

        if (entity.isPresent()) projeto = entity.get();
        else throw new NotFoundException();

        return projeto;
    }*/

    public Projeto getById(int id) throws NotFoundException{
        Projeto projeto;
        Optional<Projeto> obOptional = projetoRepository.findById(id);

        if(obOptional!=null){
            projeto = obOptional.get();
            return projeto;
        }
        throw new NotFoundException();
    }

    public void update(int id, ProjetoDTO projetoDTO)
    {
        Projeto projeto;

        try
        {
            projeto = getById(id);
            projeto.setNome(projetoDTO.getNome());

            projetoRepository.save(projeto);
        }
        catch (NotFoundException e)
        {
            e.getMessage();
        }
    }

    public void delete(int id)
    {
        projetoRepository.deleteById(id);
    }
}