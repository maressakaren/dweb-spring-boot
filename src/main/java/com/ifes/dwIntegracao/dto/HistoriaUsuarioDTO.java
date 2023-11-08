package com.ifes.dwIntegracao.dto;

import java.util.List;

import lombok.Data;

@Data

public class HistoriaUsuarioDTO {

    private String titulo;

    private String descricao;

    private String relevancia;
    
    private String categoria;

    private int idTHU;

    private int idEpico;
    
    private List<Integer> tarefas;
    
}
