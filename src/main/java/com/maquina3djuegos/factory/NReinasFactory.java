package com.maquina3djuegos.factory;

import com.maquina3djuegos.model.Juego;
import com.maquina3djuegos.model.reinas.NReinas;

public class NReinasFactory implements JuegoFactory {

    @Override
    public Juego crearJuego() {
        return (Juego) new NReinas();
    }
}
