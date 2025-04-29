package com.maquina3djuegos.adapter;

import com.maquina3djuegos.model.hanoi.HanoiSolver;

public class HanoiAdapter implements JuegoVisualAdapter {

    private final int n;

    public HanoiAdapter(int n) {
        this.n = n;
    }

    @Override
    public String obtenerTablero() {
        HanoiSolver solver = new HanoiSolver(n);
        return "";
    }
}
