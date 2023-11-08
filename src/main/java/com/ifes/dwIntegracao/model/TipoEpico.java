package com.ifes.dwIntegracao.model;

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

    /*@Column(name = "nome")
    private String nome;*/

    private List<Integer> tiposHU; //ISSO AQUI PRECISA SER UM COLLECTION

    @Column(name = "descricao")
    private String descricao;
}
