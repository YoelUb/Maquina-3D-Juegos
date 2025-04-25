package com.maquina3djuegos.controller;

import com.maquina3djuegos.service.JuegoService;
import org.springframework.stereotype.Component;

@Component
public class HanoiController {
    private final JuegoService service;

    public HanoiController(JuegoService service) {
        this.service = service;
    }

    public String ejecutar(int discos) {
        return service.resolverHanoi(discos);
    }
}
