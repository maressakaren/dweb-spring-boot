package com.ifes.dwIntegracao.repository;

import com.ifes.dwIntegracao.model.HistoriaUsuario;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriaUsuarioRepository extends JpaRepository<HistoriaUsuario, Integer>
{
}
