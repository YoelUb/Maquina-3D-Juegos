package com.maquina3djuegos.model.reinas;

public class ReinasSolver {
    private final int[] tablero;
    private int reinasColocadas;
    private int puntuacion;
    private int errores;

    public ReinasSolver(int n) {
        tablero = new int[n];
        reiniciar();
    }

    /** Carga el estado de un tablero previo */
    public void cargarTablero(int[] estado) {
        if (estado.length != tablero.length) {
            throw new IllegalArgumentException("Tamaño de tablero inválido");
        }
        System.arraycopy(estado, 0, tablero, 0, tablero.length);
        // recalcular reinasColocadas
        reinasColocadas = 0;
        for (int c : tablero) {
            if (c != -1) {
                reinasColocadas++;
            }
        }
        // NOTA: puntuación y errores los mantiene el controlador
    }

    /** Aplica la jugada en fila/col */
    public boolean jugar(int fila, int columna) {
        if (tablero[fila] != -1) {
            errores++;
            puntuacion -= 10;
            return false;
        }

        if (!esPosicionValida(fila, columna)) {
            errores++;
            puntuacion -= 10;
        }

        tablero[fila] = columna;
        reinasColocadas++;
        puntuacion += 100;
        return true;
    }


    /** Comprueba que (fila,columna) no choque con ninguna reina previa */
    public boolean esPosicionValida(int fAct, int cAct) {
        for (int fila = 0; fila < tablero.length; fila++) {
            int col = tablero[fila];
            if (col == -1) {
                continue; // no hay reina en esta fila
            }
            // misma columna
            if (col == cAct) {
                return false;
            }
            // misma diagonal: |fila - fAct| == |col - cAct|
            if (Math.abs(fila - fAct) == Math.abs(col - cAct)) {
                return false;
            }
        }
        return true;
    }

    /** True si ya hemos colocado n reinas */
    public boolean haGanado() {
        return reinasColocadas == tablero.length;
    }

    /** Devuelve una copia del tablero interno */
    public int[] getTablero() {
        return tablero.clone();
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public int getErrores() {
        return errores;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }


    public void reiniciar() {
        for (int i = 0; i < tablero.length; i++) {
            tablero[i] = -1;
        }
        reinasColocadas = 0;
        puntuacion = 0;
        errores = 0;
    }

    public String tableroComoTexto() {
        int n = tablero.length;
        StringBuilder sb = new StringBuilder();
        for (int fila = 0; fila < n; fila++) {
            for (int col = 0; col < n; col++) {
                sb.append(tablero[fila] == col ? "♛ " : ". ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}