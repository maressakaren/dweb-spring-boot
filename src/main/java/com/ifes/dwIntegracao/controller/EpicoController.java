package com.ifes.dwIntegracao.controller;

import com.ifes.dwIntegracao.application.EpicoApplication;
import com.ifes.dwIntegracao.dto.EpicoDTO;
import com.ifes.dwIntegracao.model.Epico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Epico")
public class EpicoController {
    @Autowired
    private EpicoApplication epicoApplication;

    @PostMapping("novo/")
    public Epico create(@RequestBody EpicoDTO dto) {
        return epicoApplication.create(dto);
    }

}
 