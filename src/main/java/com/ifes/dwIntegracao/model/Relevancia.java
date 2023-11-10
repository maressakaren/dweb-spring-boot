package com.ifes.dwIntegracao.model;

import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
public enum Relevancia {
    BAIXA,
    MEDIA,
    ALTA;
}
