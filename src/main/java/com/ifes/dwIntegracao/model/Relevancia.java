package com.ifes.dwIntegracao.model;

import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
public enum Relevancia {
    BAIXA("Baixa"),
    MEDIA("Média"),
    ALTA("Alta");

    private final String descricao;

    Relevancia(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}