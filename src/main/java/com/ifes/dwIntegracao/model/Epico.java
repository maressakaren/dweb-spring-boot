package com.ifes.dwIntegracao.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "epico")
public class Epico
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private int id;

   @Column(name = "titulo")
   private String titulo;
   /*
   @Column(name = "descricao")
   private String descricao;

   @Column(name = "relevancia")
   @Enumerated(EnumType.STRING)
   private Relevancia relevancia;

   @OneToOne
   @JoinColumn(name = "fk_categoria_id")
   private Categoria categoria;

   @ManyToOne
   @JoinColumn(name = "fk_projeto_id")
   private Projeto projeto;

   @ManyToOne
   @JoinColumn(name = "fk_tipo_epico_id")
   private TipoEpico tipoEpico;
   */
}