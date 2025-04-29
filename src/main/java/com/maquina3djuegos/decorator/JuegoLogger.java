package com.maquina3djuegos.decorator;

import com.maquina3djuegos.model.Juego;



public class JuegoLogger extends JuegoDecorator {

    public JuegoLogger(Juego juego) {
        super(juego);
    }

    @Override
    public void iniciarJuego() {
        System.out.println("[LOG] Inicio del juego: " + juegoDecorado.getClass().getSimpleName());
        long start = System.currentTimeMillis();

        super.iniciarJuego();

        long end = System.currentTimeMillis();
        System.out.println("[LOG] Fin del juego. Duración: " + (end - start) + " ms");
    }
}
