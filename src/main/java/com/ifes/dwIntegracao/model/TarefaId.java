package com.ifes.dwIntegracao.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
public class TarefaId {

    private Integer id;

    public TarefaId(Integer id){
        this.id = id;
    }
     
    
}
