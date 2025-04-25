package com.maquina3djuegos.command;

import com.maquina3djuegos.service.JuegoService;

public class NReinasCommand implements Command {
    private final JuegoService service;
    private final int n;

    public NReinasCommand(JuegoService service, int n) {
        this.service = service;
        this.n = n;
    }

    @Override
    public String execute() {
        return service.resolverNReinas(n);
    }
}