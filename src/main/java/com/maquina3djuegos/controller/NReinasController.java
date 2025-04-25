package com.maquina3djuegos.controller;

import com.maquina3djuegos.service.JuegoService;
import org.springframework.stereotype.Component;

@Component
public class NReinasController {
    private final JuegoService service;

    public NReinasController(JuegoService service) {
        this.service = service;
    }

    public String ejecutar(int n) {
        return service.resolverNReinas(n);
    }
}
