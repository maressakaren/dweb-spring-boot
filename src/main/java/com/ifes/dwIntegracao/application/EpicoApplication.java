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
   

    public Epico create(EpicoDTO epicoDTO){
        Epico epico;

        epico = new Epico();

        epico.setTitulo(epicoDTO.getNome());

        return repository.save(epico);
        
    }
 
}
 