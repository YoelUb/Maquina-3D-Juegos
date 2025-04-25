package com.maquina3djuegos.model.reinas;

import com.maquina3djuegos.model.Juego;

public class NReinas implements Juego {

    private String resultado = "";

    public void iniciarJuego(int n) {
        ReinasSolver solver = new ReinasSolver();
        resultado = solver.resolverComoTexto(n);
    }

    @Override
    public void iniciarJuego() {
        // Vacío para cumplir la interfaz Juego
    }

    public String mostrarResultado() {
        return resultado;
    }
}
