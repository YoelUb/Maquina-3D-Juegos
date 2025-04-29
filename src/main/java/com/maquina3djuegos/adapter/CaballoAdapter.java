package com.maquina3djuegos.adapter;

import com.maquina3djuegos.model.caballo.CaballoSolver;

public class CaballoAdapter implements JuegoVisualAdapter {

    private final int xInicial;
    private final int yInicial;

    public CaballoAdapter(int xInicial, int yInicial) {
        this.xInicial = xInicial;
        this.yInicial = yInicial;
    }

    @Override
    public String obtenerTablero() {
        // Devuelve un tablero vacío
        return generarTableroVacio();
    }

    private String generarTableroVacio() {
        StringBuilder sb = new StringBuilder();
        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                sb.append(". ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
