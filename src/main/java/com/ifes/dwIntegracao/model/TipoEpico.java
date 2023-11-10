package com.ifes.dwIntegracao.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tipo_epico")
public class TipoEpico
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    
    @Column(name = "descricao")
    private String descricao;

    @ManyToMany (cascade =  CascadeType.ALL)
    private List<TipoHistoriaUsuario> dependencias = new ArrayList<>();
}
