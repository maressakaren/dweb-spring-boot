package com.ifes.dwIntegracao.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(name = "relevancia")
    private String relevancia;

    @Column(name = "categoria")
    private String categoria;

    
    @Column(name = "fk_epico")
    private int fk_epico;
    
    @Column(name = "fk_tarefas")

    private List<Integer> dependencias; //Arrumar isso depois 
}
