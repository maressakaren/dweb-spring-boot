package com.ifes.dwIntegracao.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ifes.dwIntegracao.dto.HistoriaUsuarioDTO;
import com.ifes.dwIntegracao.exception.NotFoundException;
import com.ifes.dwIntegracao.model.Epico;
import com.ifes.dwIntegracao.model.HistoriaUsuario;
import com.ifes.dwIntegracao.repository.EpicoRepository;
import com.ifes.dwIntegracao.repository.HistoriaUsuarioRepository;

@Component
@Service
public class HistoriaUsuarioApplication {

    @Autowired
    private HistoriaUsuarioRepository repository;
    @Autowired
    private EpicoRepository epicoRepository;



    /*public List<HistoriaUsuario> gera(){
        HistoriaUsuario histUser = new HistoriaUsuario();
    
        // USAR UM FOR PARA CADA EPICO? OU PEGAR ID DO EPICO?
        histUser.setTitulo(hDTO.getTitulo());
        histUser.setRelevancia(null);
        histUser.setCategoria(null);
        histUser.setDescricao(null);
        histUser.setFk_epico(0);
        histUser.setDependencias(null);
        return null;
    }*/

    public HistoriaUsuario getById(int id)throws NotFoundException{

        Optional<HistoriaUsuario> opitional = repository.findById(id);
        HistoriaUsuario hUser;

        if(opitional!=null){
            hUser = opitional.get();
            return hUser;
        }
        throw new NotFoundException(null);
    }

    public List<HistoriaUsuario> getAll(){
        return repository.findAll();
    }

    public void update(HistoriaUsuarioDTO dto,int id) {
        HistoriaUsuario hUser;
        try {
            hUser= getById(id);

            hUser.setTitulo(dto.getTitulo());
            hUser.setRelevancia(null);
            hUser.setCategoria(null);
            hUser.setDescricao(null);
            hUser.setFk_epico(0);
            hUser.setDependencias(null);

        } catch (NotFoundException e) {
            e.getMessage();
          
        } 

    }
    public void delete(int id){
        repository.deleteById(id);
    }
    
}
