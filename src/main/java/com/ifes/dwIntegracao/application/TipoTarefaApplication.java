package com.ifes.dwIntegracao.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ifes.dwIntegracao.dto.TipoTarefaDTO;
import com.ifes.dwIntegracao.exception.NotFoundException;
import com.ifes.dwIntegracao.model.TipoTarefa;
import com.ifes.dwIntegracao.repository.TipoTarefaRepository;

@Component
public class TipoTarefaApplication {
    @Autowired
    private TipoTarefaRepository repository;
    @Autowired
    private TipoHistoriaUsuarioApplication tipoTarefaApplication;

    public TipoTarefa create(TipoTarefaDTO tipoTarefaDTO){
        
        TipoTarefa tipoTarefa = new TipoTarefa(); 
        try {
            
            tipoTarefa.setDescricao(tipoTarefaDTO.getDescricao());
            tipoTarefa.setTipoHistoriaUsuario(tipoTarefaApplication.getById(tipoTarefaDTO.getIdHistoriaUsuario()));
            /*if (tipoTarefaDTO.getDepenciasId() != null) {
                List<TipoTarefa> dependencias = new ArrayList<>();
                for (Integer dependenciaId : tipoTarefaDTO.getDepenciasId()) { 
                    TipoTarefa dependencia = this.getById(dependenciaId); 
                    if (dependencia != null) {
                        dependencias.add(dependencia);
                    }
            
                }
                tipotarefa.setIdsTarefas(dependencias);
            }*/
        return this.repository.save(tipoTarefa);
        } catch (NotFoundException e) {
            e.getMessage();
        }

        return null;
    
    }

    public TipoTarefa getById(int id) throws NotFoundException{
        TipoTarefa tipotarefa;
        Optional<TipoTarefa> opitional;

        opitional = repository.findById(id);
        if(opitional.isPresent()){
            tipotarefa = opitional.get();
            return tipotarefa;
        }
        else throw new NotFoundException("Tipo tarefa não encontrado.");
    }
    
    public List<TipoTarefa> getAll(){
        return repository.findAll();
    }

    public void update(int id,TipoTarefaDTO tipoTarefaDTO){
        TipoTarefa tipoTarefa;
        try {
            tipoTarefa = this.getById(id);
            tipoTarefa.setDescricao(tipoTarefaDTO.getDescricao());
            tipoTarefa.setTipoHistoriaUsuario(tipoTarefaApplication.getById(tipoTarefaDTO.getIdHistoriaUsuario()));
            /*if (tipoTarefaDTO.getDepenciasId() != null) {
                List<TipoTarefa> dependencias = new ArrayList<>();
                for (Integer dependenciaId : tipoTarefaDTO.getDepenciasId()) { 
                    TipoTarefa dependencia = this.getById(dependenciaId); 
                    if (dependencia != null) {
                        dependencias.add(dependencia);
                    }
            
                }
                tipoTarefa.setIdsTarefas(dependencias);
            }*/
            this.repository.save(tipoTarefa);

        } catch (NotFoundException e) {
            e.getMessage();
        }
    }
    public void delete(int id){
        repository.deleteById(id);
    }
}
