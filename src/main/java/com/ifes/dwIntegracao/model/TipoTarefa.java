package com.ifes.dwIntegracao.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table( name = "tipo_tarefa")
public class TipoTarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "fk_tipo_historia_usuario_id")
    private int fk_histor_usuario;
    
    @ManyToMany (cascade =  CascadeType.ALL)
    private List<TipoTarefa> idsTarefas;

        
}
