package com.ifes.dwIntegracao.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ifes.dwIntegracao.dto.TipoTarefaDTO;
import com.ifes.dwIntegracao.exception.NotFoundException;
import com.ifes.dwIntegracao.model.TipoHistoriaUsuario;
import com.ifes.dwIntegracao.model.TipoTarefa;
import com.ifes.dwIntegracao.repository.TipoTarefaRepository;

@Component
public class TipoTarefaApplication {
    @Autowired
    TipoTarefaRepository repository;

    public TipoTarefa create(TipoTarefaDTO tipoTarefaDTO){
        
        TipoTarefa tipotarefa = new TipoTarefa(); 
        List<Tarefa> Tipo

        tipotarefa.setDescricao(tipoTarefaDTO.getDescricao());
        tipotarefa.setFk_histor_usuario(tipoTarefaDTO.getFk_histor_usuario());
        if (tipoTarefaDTO.getDepenciasId() != null) {
                List<TipoTarefa> dependencias = new ArrayList<>();
                for (Integer dependenciaId : tipoTarefaDTO.getDepenciasId()) { // para cada dependencia no epico
                    TipoTarefa dependencia = this.getById(dependenciaId); // get by id - Recebe a dependencia do epico que esta no for
                    if (dependencia != null) {
                        dependencias.add(dependencia); // só adiciona
                    }
                }
                tipotarefa.(dependencias);//
            }
        return repository.save(tipotarefa);
    }

    public TipoTarefa getById(int id) throws NotFoundException{
        TipoTarefa tipotarefa;
        Optional<TipoTarefa> opitional;

        opitional = repository.findById(id);
        if(opitional.isPresent()){
            tipotarefa = opitional.get();
            return tipotarefa;
        }
        else throw new NotFoundException("Tipo tarefa não achado");
    }
    
    public List<TipoTarefa> getAll(){
        return repository.findAll();
    }

    public void update(int id,TipoTarefaDTO tipoTarefaDTO){
        TipoTarefa tipoTarefa;
        try {
            tipoTarefa = this.getById(id);
            tipoTarefa.setDescricao(tipoTarefaDTO.getDescricao());
            tipoTarefa.setFk_histor_usuario(tipoTarefaDTO.getFk_histor_usuario());
            tipoTarefa.setIdsTarefas(tipoTarefaDTO.getDepenciasId());
            repository.save(tipoTarefa);
        } catch (NotFoundException e) {
            e.getMessage();
        }
    }
    public void delete(int id){
        repository.deleteById(id);
    }
}
