package com.ifes.dwIntegracao.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
public class DependenciasTipoHU {

    private Integer id;

    public DependenciasTipoHU(Integer id){
        this.id = id;
    }
     
}
