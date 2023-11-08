package com.ifes.dwIntegracao.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "epico")
public class Epico
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column
   private int id;

   @Column
   private String titulo;
   
   @Column
   private String descricao;

   @Column
   @Enumerated(EnumType.STRING)
   private Relevancia relevancia;

   @OneToOne
   @JoinColumn(name = "id_categoria" )
   private Categoria categoria;

   @ManyToOne
   @JoinColumn(name = "id_projeto")
   private Projeto projeto;

   @ManyToOne
   @JoinColumn(name = "id_tipoEpico")
   private TipoEpico tipoEpico;

   @ElementCollection
   @Embedded
   private List<DependenciaEpico> dependencias;
   
}