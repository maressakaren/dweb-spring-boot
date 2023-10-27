package com.ifes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ifes.model.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
}
