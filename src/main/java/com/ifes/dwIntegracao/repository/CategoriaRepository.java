package com.ifes.dwIntegracao.repository;

import com.ifes.dwIntegracao.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>
{
}
