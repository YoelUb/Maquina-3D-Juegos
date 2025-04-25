package com.maquina3djuegos.command;

import com.maquina3djuegos.service.JuegoService;

public class CaballoCommand implements Command {
    private final JuegoService service;
    private final int x, y;

    public CaballoCommand(JuegoService service, int x, int y) {
        this.service = service;
        this.x = x; this.y = y;
    }

    @Override
    public String execute() {
        return service.resolverCaballo(x, y);
    }
}