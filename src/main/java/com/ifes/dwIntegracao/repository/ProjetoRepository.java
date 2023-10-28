package com.ifes.dwIntegracao.repository;

import com.ifes.dwIntegracao.model.Projeto;
import com.ifes.dwIntegracao.model.TipoEpico;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer>
{
}
