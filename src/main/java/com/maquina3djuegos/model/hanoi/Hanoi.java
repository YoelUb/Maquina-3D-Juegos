package com.maquina3djuegos.model.hanoi;

import com.maquina3djuegos.model.Juego;

public class Hanoi implements Juego {

    private HanoiSolverVisual solver;
    private String resultado = "";

    public Hanoi() {
        // Deja vacío
    }

    public void iniciarJuego(int numDiscos) {
        solver = new HanoiSolverVisual(numDiscos);
        resultado = ""; // Por si quieres almacenar info
    }

    @Override
    public void iniciarJuego() {
        // No se usa, requerido por la interfaz Juego
    }

    public HanoiSolverVisual getSolver() {
        return solver;
    }

    public String mostrarResultado() {
        return resultado;
    }
}
