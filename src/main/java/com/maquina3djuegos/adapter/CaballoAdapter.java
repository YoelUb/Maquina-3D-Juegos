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
        CaballoSolver solver = new CaballoSolver();
        return solver.resolverComoTexto(xInicial, yInicial);
    }
}
