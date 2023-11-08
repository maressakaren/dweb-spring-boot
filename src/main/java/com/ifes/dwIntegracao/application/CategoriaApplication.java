package com.ifes.dwIntegracao.application;

import com.ifes.dwIntegracao.exception.NotFoundException;
import com.ifes.dwIntegracao.model.Categoria;
import com.ifes.dwIntegracao.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@Service
public class CategoriaApplication
{
    @Autowired
    private CategoriaRepository repository;

    public Categoria retrieve(int id) throws NotFoundException
    {
        Optional<Categoria> entity;

        entity = repository.findById(id);

        if (entity.isPresent()) return entity.get();
        else throw new NotFoundException("Categoria não encontrada.");
    }
}
