package com.ifes.dwIntegracao.repository;

import com.ifes.dwIntegracao.model.Epico;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpicoRepository extends JpaRepository<Epico, Integer>
{
}
