package com.ifes.dwIntegracao.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tipo_historia_de_usuario")
public class TipoHistoriaUsuario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "tipo_epico" )
    private TipoEpico tipoEpico;

    @ManyToMany (cascade =  CascadeType.ALL)
    private List<TipoHistoriaUsuario> dependencias;

}
