package com.ifes.dwIntegracao.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ifes.dwIntegracao.dto.TarefaDTO;
import com.ifes.dwIntegracao.exception.NotFoundException;
import com.ifes.dwIntegracao.model.HistoriaUsuario;
import com.ifes.dwIntegracao.model.Tarefa;
import com.ifes.dwIntegracao.model.TipoTarefa;
import com.ifes.dwIntegracao.repository.TarefaRepository;

@Component
@Service
public class TarefaApplication {

    @Autowired
    private TarefaRepository repository;
    @Autowired
    private HistoriaUsuarioApplication huApplication;
    @Autowired
    private TipoTarefaApplication tipoTarefaApplication;


    public List<Tarefa> gera(int id) {
        List<Tarefa> listaTarefa = new ArrayList<>();
        List<TipoTarefa> listaTTarefa = tipoTarefaApplication.getAll();
        try {
            HistoriaUsuario historiaUser = huApplication.retrieve(id);// esta retrieve em vez de getById no TipoHistoriaUsuarioApplication
            if(listaTTarefa!= null){
                for (TipoTarefa tipoTarefa : listaTTarefa) {
                    if(tipoTarefa.getTipoHistoriaUsuario() == historiaUser.getTipoHistoriaUsuario() ){ 
                        Tarefa tarefa = new Tarefa();                 
                        tarefa.setHistoriaUsuario(historiaUser); 
                        tarefa.setDescricao(historiaUser.getDescricao());
                        tarefa.setTipoTarefa(tipoTarefa);
                        String titulo = this.geraTitulo(historiaUser.getTitulo(), tipoTarefa.getDescricao());
                        tarefa.setTitulo(titulo);                        
                        listaTarefa.add(tarefa);
                    }
                }

            }
            System.out.println(listaTarefa);
            return this.repository.saveAll(listaTarefa);
        } catch (NotFoundException e) {
            throw new RuntimeException("Erro ao gerar Tarefa.", e);
        }
    }
    public String geraTitulo(String textoHistoriaUsuario, String tipoTarefa) {

        String[] palavras = textoHistoriaUsuario.split(" ");// Separa o texto da história de usuário em palavras
        //String[] palavrasTitulo = Arrays.copyOfRange(palavras, 3, palavras.length);// Remove as palavras indesejadas do início do título
        //palavrasTitulo[palavrasTitulo.length - 1] = tipoTarefa;// Adiciona o tipo de tarefa ao final do título
        String titulo = String.join(" ", Arrays.copyOf(palavras, Math.min(4, palavras.length))) + " " + tipoTarefa + " " + palavras[palavras.length - 1];// Junta as palavras do título em uma string
    
        return titulo;
    }
    

    public Tarefa getById(int id)throws NotFoundException{

        var opitional = repository.findById(id);
        Tarefa tarefa;

        if(opitional.isEmpty()){
            tarefa = opitional.get();
            return tarefa;
        }
        throw new NotFoundException("Tarefa não encontrada.");
    }

    public List<Tarefa> getAll(){
        return repository.findAll();
    }

    public void update(TarefaDTO dto,int id) {
        Tarefa tarefa;
        try {
            tarefa= getById(id);

            tarefa.setTitulo(dto.getTitulo());
            tarefa.setDescricao(dto.getDescricao());
            tarefa.setHistoriaUsuario(dto.getHistoriaUsuario());
            this.repository.save(tarefa);
            
        
        } catch (NotFoundException e) {
            e.getMessage();
        
        } 
    }
    public void delete(int id){
        repository.deleteById(id);
    }
    
}

