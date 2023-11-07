package com.ifes.dwIntegracao.model;

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

    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "fk_tipo_epico_tipo_historia_de_usuario")
    private int tipoEpico;
}
