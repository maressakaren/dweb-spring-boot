package com.ifes.dwIntegracao.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ifes.dwIntegracao.model.Relevancia;

import lombok.Data;

@Data
public class EpicoDTO
{
   private String titulo;

   private String descricao;

   @JsonFormat(shape = JsonFormat.Shape.STRING)
   private Relevancia relevancia;

   private int categoria;

   private int projeto_id;

   private int tipoEpico_id;

   private List<Integer> dependencias;

}
