package com.maquina3djuegos.adapter;

import com.maquina3djuegos.model.reinas.NReinas;

public class NReinasAdapter implements JuegoVisualAdapter {
    private final NReinas juego;

    public NReinasAdapter(NReinas juego) {
        this.juego = juego;
    }


    @Override
    public String obtenerTablero() {
        StringBuilder sb = new StringBuilder();
        boolean[][] t = juego.getTablero();
        for (boolean[] row : t) {
            for (boolean b : row) {
                sb.append(b ? "♛ " : ". ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
