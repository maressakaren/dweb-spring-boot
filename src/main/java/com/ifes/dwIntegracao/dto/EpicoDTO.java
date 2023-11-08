package com.ifes.dwIntegracao.dto;

import com.ifes.dwIntegracao.model.Relevancia;
import lombok.Data;

@Data
public class EpicoDTO
{
    private String titulo;
    private String descricao;
    private Relevancia relevancia;
}
