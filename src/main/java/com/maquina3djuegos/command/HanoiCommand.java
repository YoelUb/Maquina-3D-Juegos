package com.maquina3djuegos.command;

import com.maquina3djuegos.service.JuegoService;

public class HanoiCommand implements Command {
    private final JuegoService service;
    private final int discos;

    public HanoiCommand(JuegoService service, int discos) {
        this.service = service;
        this.discos = discos;
    }

    @Override
    public String execute() {
        return service.resolverHanoi(discos);
    }
}