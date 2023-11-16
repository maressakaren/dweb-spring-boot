package com.ifes.dwIntegracao.model;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "historia_usuario")
public class HistoriaUsuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column (name = "titulo")
    private String titulo;

    @Column(name ="descricao")
    private String descricao;

    @Column
    @Enumerated(EnumType.STRING)
    private Relevancia relevancia;

    /*@ManyToOne
    @JoinColumn*/
    private String categoria;
   
    @ManyToOne
    @JoinColumn
    private Epico epico;

    @ManyToOne
    @JoinColumn
    private TipoHistoriaUsuario tipoHistoriaUsuario;
    
    /*@ManyToMany (cascade =  CascadeType.ALL)
    private List<TipoHistoriaUsuario> dependencias; */
}
