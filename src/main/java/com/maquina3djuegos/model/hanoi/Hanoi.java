package com.maquina3djuegos.model.hanoi;

import com.maquina3djuegos.model.Juego;
import java.util.List;

public class Hanoi implements Juego {

    private String resultado = "";

    public void iniciarJuego(int n) {
        HanoiSolver solver = new HanoiSolver();
        resultado = solver.resolverComoTexto(n, 'A', 'B', 'C');
    }

    @Override
    public void iniciarJuego() {
        // Método vacío para cumplir la interfaz Juego
    }

    public String mostrarResultado() {
        return resultado;
    }

    private String imprimirTablero(List<String> movimientos) {
        StringBuilder sb = new StringBuilder();
        for (String movimiento : movimientos) {
            sb.append(movimiento).append("\n");
        }
        return sb.toString();
    }
}
