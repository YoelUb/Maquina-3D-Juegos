package com.maquina3djuegos.model.caballo;

import com.maquina3djuegos.model.Juego;

public class Caballo implements Juego {

    private String resultado = "";

    public void iniciarJuego(int filas, int columnas) {
        CaballoSolver solver = new CaballoSolver();
        resultado = solver.resolverComoTexto(filas, columnas);
    }

    public String mostrarResultado() {
        return resultado;
    }

    @Override
    public void iniciarJuego() {
        // Vacío para cumplir la interfaz
    }

}
