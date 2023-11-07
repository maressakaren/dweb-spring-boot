package com.ifes.dwIntegracao.application;

import com.ifes.dwIntegracao.dto.TipoEpicoDTO;
import com.ifes.dwIntegracao.exception.NotFoundException;
import com.ifes.dwIntegracao.model.TipoEpico;
import com.ifes.dwIntegracao.repository.TipoEpicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class TipoEpicoApplication
{
    @Autowired
    TipoEpicoRepository repository;

    public TipoEpico create(TipoEpicoDTO tipoEpicoDTO)
    {
        TipoEpico tipoEpico;

        tipoEpico = new TipoEpico();
        //tipoEpico.setNome(tipoEpicoDTO.getNome());
        tipoEpico.setDescricao(tipoEpicoDTO.getDescricao());

        return repository.save(tipoEpico);
    }

    public TipoEpico retrieve(int id) throws NotFoundException
    {
        TipoEpico tipoEpico;
        Optional<TipoEpico> entity;

        entity = repository.findById(id);

        if (entity.isPresent()) tipoEpico = entity.get();
        else throw new NotFoundException("Tipo Épico não encontrado.");

        return tipoEpico;
    }

    public List<TipoEpico> retrieveAll()
    {
        return repository.findAll();
    }

    public void update(int id, TipoEpicoDTO tipoEpicoDTO)
    {
        TipoEpico tipoEpico;

        try
        {
            tipoEpico = retrieve(id);
            //tipoEpico.setNome(tipoEpicoDTO.getNome());
            tipoEpico.setDescricao(tipoEpicoDTO.getDescricao());

            repository.save(tipoEpico);
        }
        catch (NotFoundException e)
        {
            e.getMessage();
        }
    }

    public void delete(int id)
    {
        repository.deleteById(id);
    }
}