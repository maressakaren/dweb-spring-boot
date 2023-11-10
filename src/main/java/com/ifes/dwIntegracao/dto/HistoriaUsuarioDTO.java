package com.ifes.dwIntegracao.dto;

import java.util.List;

import com.ifes.dwIntegracao.model.Categoria;
import com.ifes.dwIntegracao.model.Epico;
import com.ifes.dwIntegracao.model.Relevancia;
import com.ifes.dwIntegracao.model.TipoEpico;
import com.ifes.dwIntegracao.model.TipoHistoriaUsuario;

import lombok.Data;

@Data

public class HistoriaUsuarioDTO {

    private String titulo;

    private String descricao;

    private Relevancia relevancia;
    
    private Categoria categoria;

    private Epico epico;
    
    private List<TipoHistoriaUsuario> dependencias;
    
}
