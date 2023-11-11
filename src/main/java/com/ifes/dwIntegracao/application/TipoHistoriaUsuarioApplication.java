package com.ifes.dwIntegracao.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ifes.dwIntegracao.dto.TipoHistoriaUsuarioDTO;
import com.ifes.dwIntegracao.exception.NotFoundException;
import com.ifes.dwIntegracao.model.TipoHistoriaUsuario;
import com.ifes.dwIntegracao.repository.TipoEpicoRepository;
import com.ifes.dwIntegracao.repository.TipoHistoriaUsuarioRepository;

@Component
public class TipoHistoriaUsuarioApplication {
    @Autowired
    TipoHistoriaUsuarioRepository tipoHURepository;
    @Autowired
    TipoEpicoRepository tErepository;
    TipoEpicoApplication appTipoEpico;

    public TipoHistoriaUsuario create(TipoHistoriaUsuarioDTO tipoHUdto){

        TipoHistoriaUsuario tipoHU = new TipoHistoriaUsuario();

        try {
            tipoHU.setDescricao(tipoHUdto.getDescricao());
            tipoHU.setTipoEpico(appTipoEpico.retrieve(tipoHUdto.getIdEpico()));
            /*if (tipoHU.getDependencias() != null) {
                List<TipoHistoriaUsuario> dependencias = new ArrayList<>();
                for (Integer dependenciaId : tipoHUdto.getDependencias()) { // para cada dependencia no epico
                    TipoHistoriaUsuario dependencia = this.getById(dependenciaId); // get by id - Recebe a dependencia do epico que esta no for
                    if (dependencia != null) {
                        dependencias.add(dependencia); // só adiciona
                    }
                }
                tipoHU.setDependencias(dependencias);//
            }
            */
            tipoHURepository.save(tipoHU);
        
        } catch (NotFoundException e) {
            e.getMessage();
        }
        return null;
    }

    public TipoHistoriaUsuario getById(int id) throws NotFoundException{
        TipoHistoriaUsuario tipoHU;
        Optional<TipoHistoriaUsuario> opTipoHU;
        
        opTipoHU = tipoHURepository.findById(id);
        if(opTipoHU.isPresent()){ 
            tipoHU = opTipoHU.get();
            return tipoHU;
        }

        throw new NotFoundException("Tipo de História de Usuário não encontrado.");
    }
    
    public List<TipoHistoriaUsuario> getAll(){
        return tipoHURepository.findAll();
    }

    public void update(int id,TipoHistoriaUsuarioDTO tipoHUdto){
        TipoHistoriaUsuario tipoHU;
        try {
            tipoHU = getById(id);
            tipoHU.setDescricao(tipoHUdto.getDescricao());
            /*

                        //vai ficar aqui
            if (tipoHU.getDependencias() != null) {
                List<TipoHistoriaUsuario> dependencias = new ArrayList<>();
                for (Integer dependenciaId : tipoHUdto.getDependencias()) { // para cada dependencia no epico
                    TipoHistoriaUsuario dependencia = this.getById(dependenciaId); // get by id - Recebe a dependencia do epico que esta no for
                    if (dependencia != null) {
                        dependencias.add(dependencia); // só adiciona
                    }
                }
                tipoHU.setDependencias(dependencias);//
            }
            */
            tipoHURepository.save(tipoHU); 

        }catch (NotFoundException e)
        {
            e.getMessage();
        }
    }
    public void delete(int id){
        tipoHURepository.deleteById(id);
    }
    
}
