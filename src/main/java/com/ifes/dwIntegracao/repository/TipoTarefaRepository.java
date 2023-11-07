package com.ifes.dwIntegracao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifes.dwIntegracao.model.TipoTarefa;

@Repository
public interface TipoTarefaRepository extends JpaRepository<TipoTarefa,Integer> {
    
}
