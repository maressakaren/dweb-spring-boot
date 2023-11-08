package com.ifes.dwIntegracao.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor

public class DependenciaEpico {
    private int id;

    DependenciaEpico (int id){
        this.id = id;
    }
}

