package com.ifes.dwIntegracao.repository;

import com.ifes.dwIntegracao.model.TipoEpico;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEpicoRepository extends JpaRepository<TipoEpico, Integer>
{
}
