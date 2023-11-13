package com.ifes.dwIntegracao.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        List<TipoHistoriaUsuario> listaTHU = tipoHApplicatio.getAll();
        try {
            Epico epico = epicoApplication.retrieve(id);
            if(listaTHU!= null){
                for (TipoHistoriaUsuario tipoHU : listaTHU) {
                    if(tipoHU.getTipoEpico() == epico.getTipoEpico() ){
                        HistoriaUsuario histUser = new HistoriaUsuario();                 
                        histUser.setCategoria(epico.getCategoria());
                        histUser.setRelevancia(epico.getRelevancia());
                        histUser.setEpico(epico);
                        histUser.setDescricao(epico.getDescricao());
                        String titulo = this.geraTitulo(epico.getTitulo(), tipoHU.getDescricao());
                        histUser.setTitulo(titulo);
                        listaHU.add(histUser);
                    }
                }

            }
            System.out.println(listaHU);
            return null;
        } catch (NotFoundException e) {
            throw new RuntimeException("Erro ao gerar História de Usuário", e);
        }
    }
    public String geraTitulo(String texto, String tipoHU){
        String[] palavras = texto.split(" ");
        String texto2 = String.join(" ", Arrays.copyOf(palavras, Math.min(4, palavras.length))) + tipoHU + palavras[palavras.length-1];

        return texto2;

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
