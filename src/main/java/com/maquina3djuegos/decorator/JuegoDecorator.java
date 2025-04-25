package com.maquina3djuegos.decorator;


import com.maquina3djuegos.model.Juego;

public abstract class JuegoDecorator implements Juego {
    protected Juego juegoDecorado;

    public JuegoDecorator(Juego juego) {
        this.juegoDecorado = juego;
    }

    @Override
    public void iniciarJuego() {
        juegoDecorado.iniciarJuego();
    }
}