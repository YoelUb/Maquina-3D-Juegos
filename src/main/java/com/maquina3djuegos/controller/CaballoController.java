package com.maquina3djuegos.controller;


import com.maquina3djuegos.service.JuegoService;
import org.springframework.stereotype.Component;

@Component
public class CaballoController {
    private final JuegoService service;

    public CaballoController(JuegoService service) {
        this.service = service;
    }

    public String ejecutar(int x, int y) {
        return service.resolverCaballo(x, y);
    }
}

