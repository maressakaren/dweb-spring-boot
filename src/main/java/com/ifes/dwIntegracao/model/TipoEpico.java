package com.ifes.dwIntegracao.model;

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

    /*@Column(name = "nome")
    private String nome;*/

    @Column(name = "descricao")
    private String descricao;
}
