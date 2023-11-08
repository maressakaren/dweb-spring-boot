package com.ifes.dwIntegracao.repository;

import com.ifes.dwIntegracao.model.Projeto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer>
{
}
