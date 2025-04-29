package com.maquina3djuegos.model.reinas;

public class NReinas {
    private final int size = 8;
    private final boolean[][] tablero = new boolean[size][size];
    private int errores = 0;
    private int puntuacion = 0;

    public NReinas() {
        // tablero ya inicia en false
    }

    /**
     * Si ya había reina en (f,c), la quita y resta 50 pts
     * Si no, intenta colocar:
     *   - si conflicto, +1 error y -10 pts, devuelve false
     *   - si válido, coloca, +100 pts, devuelve true
     */
    public boolean colocar(int f, int c) {
        if (tablero[f][c]) {
            // quita
            tablero[f][c] = false;
            puntuacion = Math.max(0, puntuacion - 50);
            return true;
        }
        // intenta colocar
        if (hayConflicto(f, c)) {
            errores++;
            puntuacion = Math.max(0, puntuacion - 10);
            return false;
        }
        tablero[f][c] = true;
        puntuacion += 100;
        return true;
    }

    public boolean esVictoria() {
        int cnt = 0;
        for (boolean[] row : tablero)
            for (boolean b : row)
                if (b) cnt++;
        return cnt == size;
    }

    private boolean hayConflicto(int f, int c) {
        // filas/columnas
        for (int i = 0; i < size; i++) {
            if ((i != c && tablero[f][i]) || (i != f && tablero[i][c]))
                return true;
        }
        // diagonales
        for (int d = 1; d < size; d++) {
            if (f+d < size && c+d < size && tablero[f+d][c+d]) return true;
            if (f+d < size && c-d >= 0    && tablero[f+d][c-d]) return true;
            if (f-d >= 0    && c+d < size && tablero[f-d][c+d]) return true;
            if (f-d >= 0    && c-d >= 0    && tablero[f-d][c-d]) return true;
        }
        return false;
    }

    /** Para tu DTO: a cada fila le asigna la columna de la reina o -1 si no hay */
    public int[] getTablero1D() {
        int[] estado = new int[size];
        for (int f = 0; f < size; f++) {
            int colReina = -1;
            for (int c = 0; c < size; c++) {
                if (tablero[f][c]) {
                    colReina = c;
                    break;
                }
            }
            estado[f] = colReina;
        }
        return estado;
    }

    public boolean esPosicionValida(int f, int c) {
        if (tablero[f][c]) {
            // si ya hay reina, técnicamente no es “poner” aquí, pero lo consideramos inválido
            return false;
        }
        // chequea conflicto exactamente igual que en colocar()
        // filas/columnas
        for (int i = 0; i < size; i++) {
            if ((i != c && tablero[f][i]) || (i != f && tablero[i][c])) {
                return false;
            }
        }
        // diagonales
        for (int d = 1; d < size; d++) {
            if (f+d < size && c+d < size && tablero[f+d][c+d]) return false;
            if (f+d < size && c-d >= 0    && tablero[f+d][c-d]) return false;
            if (f-d >= 0    && c+d < size && tablero[f-d][c+d]) return false;
            if (f-d >= 0    && c-d >= 0    && tablero[f-d][c-d]) return false;
        }
        return true;
    }

    // getters para controller
    public int getErrores()    { return errores; }
    public int getPuntuacion() { return puntuacion; }
    public boolean[][] getTablero() {
        return tablero;
    }
}
