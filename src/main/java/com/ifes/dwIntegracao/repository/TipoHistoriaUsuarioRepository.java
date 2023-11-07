package com.ifes.dwIntegracao.repository;

import com.ifes.dwIntegracao.model.TipoHistoriaUsuario;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoHistoriaUsuarioRepository extends JpaRepository<TipoHistoriaUsuario, Integer>
{
}
