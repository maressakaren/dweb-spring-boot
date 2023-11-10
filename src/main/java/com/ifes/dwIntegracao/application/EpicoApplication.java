package com.ifes.dwIntegracao.application;

import com.ifes.dwIntegracao.dto.EpicoDTO;
import com.ifes.dwIntegracao.exception.NotFoundException;
import com.ifes.dwIntegracao.model.DependenciasTipoHU;
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

    public Epico create(EpicoDTO epicoDTO)
    {
        Epico epico;

        epico = new Epico();
        try {
            epico.setTitulo(epicoDTO.getTitulo());
            epico.setDescricao(epicoDTO.getDescricao());
            epico.setRelevancia(epicoDTO.getRelevancia());
            epico.setCategoria(categoriaApplication.retrieve(epicoDTO.getCategoria()));
            epico.setProjeto(projetoApplication.getById(epicoDTO.getProjeto_id()));
            epico.setTipoEpico(tipoEpicoApplication.retrieve(epicoDTO.getTipoEpico_id()));
            if (epicoDTO.getDependencias() != null) {
                List<Epico> dependencias = new ArrayList<>();
                for (Integer dependenciaId : epicoDTO.getDependencias()) {
                    Epico dependencia = this.retrieve(dependenciaId);
                    if (dependencia != null) {
                        dependencias.add(dependencia);
                    }
                }
                epico.setDependencias(dependencias);
            }

            return repository.save(epico);
        } catch (NotFoundException e) {
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
           // epico.setDependencias(epicoDTO.getDependencias());
            if (epicoDTO.getDependencias() != null) {
                List<Epico> dependencias = new ArrayList<>();
                for (Integer dependenciaId : epicoDTO.getDependencias()) {
                    Epico dependencia = this.retrieve(dependenciaId);
                    if (dependencia != null) {
                        dependencias.add(dependencia);
                    }
                }
                epico.setDependencias(dependencias);
            }

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