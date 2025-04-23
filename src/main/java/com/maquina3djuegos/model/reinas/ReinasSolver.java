package com.maquina3djuegos.model.reinas;

public class ReinasSolver {

    public void resolver(int n) {
        int[] tablero = new int[n];
        if (colocarReinas(tablero, 0)) {
            imprimirTablero(tablero);
        } else {
            System.out.println("No se encontró solución.");
        }
    }

    private boolean colocarReinas(int[] tablero, int fila) {
        if (fila == tablero.length) {
            return true;
        }

        for (int col = 0; col < tablero.length; col++) {
            if (esPosicionValida(tablero, fila, col)) {
                tablero[fila] = col;
                if (colocarReinas(tablero, fila + 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean esPosicionValida(int[] tablero, int filaActual, int colActual) {
        for (int filaAnterior = 0; filaAnterior < filaActual; filaAnterior++) {
            int colAnterior = tablero[filaAnterior];

            // Misma columna
            if (colAnterior == colActual) return false;

            // Misma diagonal
            if (Math.abs(colAnterior - colActual) == Math.abs(filaAnterior - filaActual)) return false;
        }
        return true;
    }

    private void imprimirTablero(int[] tablero) {
        for (int fila : tablero) {
            for (int col = 0; col < tablero.length; col++) {
                if (col == fila) System.out.print(" Q ");
                else System.out.print(" . ");
            }
            System.out.println();
        }
    }
}
