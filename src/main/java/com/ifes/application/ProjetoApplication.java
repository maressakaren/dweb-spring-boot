package com.ifes.application;

import java.util.List;

import com.ifes.model.Projeto;
import com.ifes.repository.ProjetoRepository;

public class ProjetoApplication {

    private final ProjetoRepository projetoRepository;

    public ProjetoApplication(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public List<Projeto> getAll() {
        return projetoRepository.findAll();
    }

    public Projeto findById(Integer id) throws ProjetoNotFoundException {
        return projetoRepository.findById(id).orElseThrow(ProjetoNotFoundException::new);
    }

    public Projeto save(Projeto projeto) {
        projetoRepository.save(projeto);
        return projeto;
    }

    public Projeto delete(Integer id) throws ProjetoNotFoundException {
        Projeto projeto = findById(id);
        projetoRepository.deleteById(id);
        return projeto;
    }

    public Projeto update(Projeto projeto) throws ProjetoNotFoundException {
        Projeto projetoAntigo = findById(projeto.getId());
        projetoAntigo.setNome(projeto.getNome());
        return projetoRepository.save(projetoAntigo);
    }
}
