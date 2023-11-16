package com.ifes.dwIntegracao.dto;

import java.util.List;

import com.ifes.dwIntegracao.model.HistoriaUsuario;
import lombok.Data;

@Data

public class TarefaDTO {

    private String titulo;

    private String descricao;

    private int historiaUserId;

    private int tipoTarefaId;
    
    //private List<Integer> dependencias;
    
}
