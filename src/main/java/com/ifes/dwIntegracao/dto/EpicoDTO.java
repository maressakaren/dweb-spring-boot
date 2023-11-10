package com.ifes.dwIntegracao.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ifes.dwIntegracao.model.Categoria;
import com.ifes.dwIntegracao.model.DependenciasEpico;
import com.ifes.dwIntegracao.model.DependenciasTipoHU;
import com.ifes.dwIntegracao.model.Epico;
import com.ifes.dwIntegracao.model.Projeto;
import com.ifes.dwIntegracao.model.Relevancia;
import com.ifes.dwIntegracao.model.TipoEpico;

import lombok.Data;

@Data
public class EpicoDTO
{
   private String titulo;

   private String descricao;

   @JsonFormat(shape = JsonFormat.Shape.OBJECT)
   private Relevancia relevancia;

   private int categoria;

   private int projeto_id;

   private int tipoEpico_id;

   private List<Integer> dependencias;

}
