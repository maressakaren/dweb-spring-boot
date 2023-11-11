package com.ifes.dwIntegracao.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ifes.dwIntegracao.dto.HistoriaUsuarioDTO;
import com.ifes.dwIntegracao.exception.NotFoundException;
import com.ifes.dwIntegracao.model.Epico;
import com.ifes.dwIntegracao.model.HistoriaUsuario;
import com.ifes.dwIntegracao.model.TipoHistoriaUsuario;
import com.ifes.dwIntegracao.repository.HistoriaUsuarioRepository;

@Component
@Service
public class HistoriaUsuarioApplication {

    @Autowired
    private HistoriaUsuarioRepository repository;
    @Autowired
    private EpicoApplication epicoApplication;
    @Autowired
    private TipoHistoriaUsuarioApplication tipoHApplicatio;


    public List<HistoriaUsuario> gera(int id) {
        List<HistoriaUsuario> listaHU = new ArrayList<>();
        try {
            Epico epico = epicoApplication.retrieve(id);
            
            for (TipoHistoriaUsuario tipoHU : epico.getTipoEpico().getHistoriasUser()) {
                String[] texto = epico.getTitulo().split("\\s+");
                
                HistoriaUsuario histUser = new HistoriaUsuario();
                histUser.setCategoria(epico.getCategoria());
                histUser.setRelevancia(epico.getRelevancia());
                histUser.setEpico(epico);
                //histUser.setDependencias(epico.getTipoEpico().getDependencias());
                histUser.setDescricao(epico.getDescricao());

                String titulo = epico.getTitulo().substring(0, 3) + tipoHU.getDescricao() + " " + texto[texto.length - 1];
                histUser.setTitulo(titulo);
                listaHU.add(histUser);
            }
            return listaHU;
        } catch (NotFoundException e) {
            // Log ou relançar a exceção, dependendo dos requisitos
            throw new RuntimeException("Erro ao gerar História de Usuário", e);
        }
    }

    public HistoriaUsuario getById(int id)throws NotFoundException{

        var opitional = repository.findById(id);
        HistoriaUsuario hUser;

        if(opitional.isEmpty()){
            hUser = opitional.get();
            return hUser;
        }
        throw new NotFoundException("Historia não encontrada.");
    }

    public List<HistoriaUsuario> getAll(){
        return repository.findAll();
    }

    public void update(HistoriaUsuarioDTO dto,int id) {
        HistoriaUsuario hUser;
        try {
            hUser= getById(id);

            hUser.setTitulo(dto.getTitulo());
            hUser.setRelevancia(dto.getRelevancia());
            hUser.setCategoria(dto.getCategoria());
            hUser.setDescricao(dto.getDescricao());
            hUser.setEpico(dto.getEpico());
            this.repository.save(hUser);
              
           
        } catch (NotFoundException e) {
            e.getMessage();
          
        } 

    }
    public void delete(int id){
        repository.deleteById(id);
    }
    
}
