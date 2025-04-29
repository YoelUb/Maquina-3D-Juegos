package com.maquina3djuegos.factory;

import com.maquina3djuegos.model.Juego;
import com.maquina3djuegos.model.hanoi.Hanoi;

public class HanoiFactory implements JuegoFactory{

    @Override
    public Juego crearJuego() {
        return new Hanoi();
    }
}
