package com.ifes.dwIntegracao.repository;

import com.ifes.dwIntegracao.model.Tarefa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer>
{
}
