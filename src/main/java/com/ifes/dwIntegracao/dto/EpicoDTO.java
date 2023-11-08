package com.ifes.dwIntegracao.dto;

import java.util.List;

import com.ifes.dwIntegracao.model.Categoria;
import com.ifes.dwIntegracao.model.DependenciaEpico;
import com.ifes.dwIntegracao.model.Projeto;
import com.ifes.dwIntegracao.model.Relevancia;
import com.ifes.dwIntegracao.model.TipoEpico;

import lombok.Data;

@Data
public class EpicoDTO
{
   private String titulo;

   private String descricao;

   private Relevancia relevancia;

   private int categoria;

   private int projeto_id;

   private int tipoEpico_id;

   private List<DependenciaEpico> dependencias;

}
