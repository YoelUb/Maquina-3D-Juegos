package com.maquina3djuegos.model.reinas;

import com.maquina3djuegos.model.Juego;

public class NReinas implements Juego {

    private String resultado = "";


    @Override
    public void iniciarJuego() {
        // Vacío para cumplir la interfaz Juego
    }

    public String mostrarResultado() {
        return resultado;
    }
}
