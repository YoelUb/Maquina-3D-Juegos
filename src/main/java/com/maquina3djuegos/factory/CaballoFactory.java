package com.maquina3djuegos.factory;

import com.maquina3djuegos.model.Juego;
import com.maquina3djuegos.model.caballo.Caballo;

public class CaballoFactory implements JuegoFactory {
    public Juego crearJuego() {
        return new Caballo();
    }
}
