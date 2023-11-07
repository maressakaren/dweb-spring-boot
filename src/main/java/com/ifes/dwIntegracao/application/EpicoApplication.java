package com.ifes.dwIntegracao.application;

import com.ifes.dwIntegracao.dto.EpicoDTO;
import com.ifes.dwIntegracao.exception.NotFoundException;
import com.ifes.dwIntegracao.model.Epico;
import com.ifes.dwIntegracao.repository.EpicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class EpicoApplication
{
    @Autowired
    private EpicoRepository repository;
    @Autowired
    private CategoriaApplication categoriaApplication;
    @Autowired
    private ProjetoApplication projetoApplication;
    @Autowired
    private TipoEpicoApplication tipoEpicoApplication;

    public Epico create(EpicoDTO epicoDTO, int categoriaId, int projetoId, int tipoEpicoId)
    {
        Epico epico;

        epico = new Epico();

        epico.setTitulo(epicoDTO.getTitulo());
        epico.setDescricao(epicoDTO.getDescricao());
        epico.setRelevancia(epicoDTO.getRelevancia());

        try
        {
            epico.setCategoria(categoriaApplication.retrieve(categoriaId));
            epico.setProjeto(projetoApplication.getById(projetoId));
            epico.setTipoEpico(tipoEpicoApplication.retrieve(tipoEpicoId));

            return repository.save(epico);
        }
        catch (NotFoundException e)
        {
            e.getMessage();
        }

        return null;
    }

    public Epico retrieve(int id) throws NotFoundException
    {
        Optional<Epico> entity;

        entity = repository.findById(id);

        if (entity.isPresent()) return entity.get();
        else throw new NotFoundException("Épico não encontrado");
    }

    public List<Epico> retrieveAll()
    {
        return repository.findAll();
    }

    public Epico update(int id, EpicoDTO epicoDTO)
    {
        Epico epico;

        try
        {
            epico = retrieve(id);
            epico.setTitulo(epicoDTO.getTitulo());
            epico.setDescricao(epicoDTO.getDescricao());
            epico.setRelevancia(epicoDTO.getRelevancia());

            return repository.save(epico);
        }
        catch (NotFoundException e)
        {
            e.getMessage();
        }

        return null;
    }

    public void delete(int id)
    {
        repository.deleteById(id);
    }
}
