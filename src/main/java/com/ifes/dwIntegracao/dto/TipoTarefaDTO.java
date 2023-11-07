package com.ifes.dwIntegracao.dto;

import lombok.Data;

import java.util.List;

import com.ifes.dwIntegracao.model.TarefaId;

@Data
public class TipoTarefaDTO {
    private String descricao;
    private int fk_histor_usuario;
    private List<TarefaId> depenciasId;
   
}
