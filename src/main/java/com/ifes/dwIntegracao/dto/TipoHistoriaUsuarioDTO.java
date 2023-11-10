package com.ifes.dwIntegracao.dto;

import java.util.List;


import lombok.Data;
@Data
public class TipoHistoriaUsuarioDTO {

    private String descricao;  
    
    private int idEpico;

    private List<Integer> dependencias;
}
