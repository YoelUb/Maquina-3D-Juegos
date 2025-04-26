package com.maquina3djuegos.adapter;

import com.maquina3djuegos.model.reinas.ReinasSolver;

public class NReinasAdapter implements JuegoVisualAdapter {

    private final int n;

    public NReinasAdapter(int n) {
        this.n = n;
    }

    @Override
    public String obtenerTablero() {
        ReinasSolver solver = new ReinasSolver(n);
        return solver.tableroComoTexto();
    }
}
