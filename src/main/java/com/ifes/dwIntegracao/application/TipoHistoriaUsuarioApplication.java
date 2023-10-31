package com.ifes.dwIntegracao.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ifes.dwIntegracao.dto.TipoHistoriaUsuarioDTO;
import com.ifes.dwIntegracao.exception.NotFoundException;
import com.ifes.dwIntegracao.model.TipoEpico;
import com.ifes.dwIntegracao.model.TipoHistoriaUsuario;
import com.ifes.dwIntegracao.repository.TipoEpicoRepository;
import com.ifes.dwIntegracao.repository.TipoHistoriaUsuarioRepository;

@Component
public class TipoHistoriaUsuarioApplication {
    @Autowired
    TipoHistoriaUsuarioRepository tipoHURepository;
    @Autowired
    TipoEpicoRepository tErepository;

    public TipoHistoriaUsuario create(TipoHistoriaUsuarioDTO tipoHUdto, int id){

        TipoHistoriaUsuario tipoHU = new TipoHistoriaUsuario();
        //TipoEpico tipoEpico = (tErepository.findById(id)).get();

        tipoHU.setDescricao(tipoHUdto.getDescricao());
        tipoHU.setTipoEpico(id);
        return tipoHURepository.save(tipoHU);
    }

    public TipoHistoriaUsuario getById(int id) throws NotFoundException{
        TipoHistoriaUsuario tipoHU;
        Optional<TipoHistoriaUsuario> opTipoHU;
        
        opTipoHU = tipoHURepository.findById(id);
        if(opTipoHU!=null){ 
            tipoHU = opTipoHU.get();
            return tipoHU;
        }

        throw new NotFoundException();
    }
    
    public List<TipoHistoriaUsuario> getAll(){
        return tipoHURepository.findAll();
    }

    public void update(int id,TipoHistoriaUsuarioDTO tipoHUdto){
        TipoHistoriaUsuario tipoHU;
        try {
            tipoHU = getById(id);
            tipoHU.setDescricao(tipoHUdto.getDescricao());
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
