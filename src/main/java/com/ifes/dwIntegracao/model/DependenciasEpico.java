package com.ifes.dwIntegracao.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor

public class DependenciasEpico {
    private int id;

    DependenciasEpico (int id){
        this.id = id;
    }
}

