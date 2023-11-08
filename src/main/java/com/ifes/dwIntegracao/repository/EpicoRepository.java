package com.ifes.dwIntegracao.repository;

import com.ifes.dwIntegracao.model.Epico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpicoRepository extends JpaRepository<Epico, Integer>
{
}
