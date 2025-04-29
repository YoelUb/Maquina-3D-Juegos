package com.maquina3djuegos.model.reinas;

public class NReinas {
    private final int size = 8;
    private final boolean[][] tablero = new boolean[size][size];
    private int errores = 0;

    /** Intenta colocar reina; si hay conflicto o ya hay una, cuenta error. */
    public boolean colocar(int fila, int col) {
        if (tablero[fila][col] || hayConflicto(fila, col)) {
            errores++;
            return false;
        }
        tablero[fila][col] = true;
        return true;
    }

    /** (Opcional) Permite quitar una reina. */
    public boolean quitar(int fila, int col) {
        if (tablero[fila][col]) {
            tablero[fila][col] = false;
            return true;
        }
        return false;
    }

    /** Verdadero sólo cuando hay 8 reinas colocadas correctamente. */
    public boolean esVictoria() {
        int cnt = 0;
        for (boolean[] row : tablero)
            for (boolean b : row)
                if (b) cnt++;
        return cnt == size;
    }

    /** Comprueba conflictos sobre filas, columnas y diagonales. */
    private boolean hayConflicto(int f, int c) {
        for (int i = 0; i < size; i++) {
            if ((i != c && tablero[f][i]) || (i != f && tablero[i][c])) {
                return true;
            }
        }
        for (int d = 1; d < size; d++) {
            if (f+d < size && c+d < size && tablero[f+d][c+d]) return true;
            if (f+d < size && c-d >= 0    && tablero[f+d][c-d]) return true;
            if (f-d >= 0    && c+d < size && tablero[f-d][c+d]) return true;
            if (f-d >= 0    && c-d >= 0    && tablero[f-d][c-d]) return true;
        }
        return false;
    }

    public int[] getTablero1D() {
        int[] estado = new int[size];
        for (int fila = 0; fila < size; fila++) {
            int colReina = -1;
            for (int col = 0; col < size; col++) {
                if (tablero[fila][col]) {
                    colReina = col;
                    break;
                }
            }
            estado[fila] = colReina;
        }
        return estado;
    }

    // Getters para el controlador / adapter
    public boolean[][] getTablero() { return tablero; }
    public int getErrores()         { return errores; }
}
