package com.ifes.dwIntegracao.application;

import com.ifes.dwIntegracao.dto.ProjetoDTO;
import com.ifes.dwIntegracao.dto.TipoEpicoDTO;
import com.ifes.dwIntegracao.exception.NotFoundException;
import com.ifes.dwIntegracao.model.Projeto;
import com.ifes.dwIntegracao.model.TipoEpico;
import com.ifes.dwIntegracao.repository.ProjetoRepository;
import com.ifes.dwIntegracao.repository.TipoEpicoRepository;
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

    public Projeto retrieve(int id) throws NotFoundException
    {
        Projeto projeto;
        Optional<Projeto> entity;

        entity = projetoRepository.findById(id);

        if (entity.isPresent()) projeto = entity.get();
        else throw new NotFoundException();

        return projeto;
    }

    public void update(int id, TipoEpicoDTO tipoEpicoDTO)
    {
        TipoEpico tipoEpico;

        try
        {
            tipoEpico = retrieve(id);
            tipoEpico.setNome(tipoEpicoDTO.getNome());
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
        projetoRepository.deleteById(id);
    }
}