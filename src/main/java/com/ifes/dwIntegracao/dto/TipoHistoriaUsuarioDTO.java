package com.ifes.dwIntegracao.dto;

import java.util.List;

import com.ifes.dwIntegracao.model.DependenciasTipoHU;
import com.ifes.dwIntegracao.model.TipoHistoriaUsuario;

import lombok.Data;
@Data
public class TipoHistoriaUsuarioDTO {

    private String descricao;  
    
    private int idEpico;

    private List<Integer> dependencias;
}
