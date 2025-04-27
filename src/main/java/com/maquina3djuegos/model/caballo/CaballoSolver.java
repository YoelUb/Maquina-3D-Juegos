package com.maquina3djuegos.model.caballo;

public class CaballoSolver {
    private final int N = 8;
    private int[][] tablero;
    private int xActual;
    private int yActual;
    private int paso;
    private int puntuacion;
    private int errores;

    public CaballoSolver() {
        tablero = new int[N][N];
        reiniciar();
    }

    /** Reinicia el tablero */
    public void reiniciar() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                tablero[i][j] = -1;
        paso = 0;
        puntuacion = 0;
        errores = 0;
        xActual = -1;
        yActual = -1;
    }

    /** Carga el tablero enviado desde el cliente */
    public void cargarTablero(int[] estado) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tablero[i][j] = estado[i * N + j];
                if (tablero[i][j] != -1 && tablero[i][j] >= paso) {
                    paso = tablero[i][j] + 1;
                    xActual = i;
                    yActual = j;
                }
            }
        }
    }

    /** Realiza un movimiento */
    public boolean jugar(int fila, int columna) {
        if (paso == 0) { // Primer movimiento
            tablero[fila][columna] = paso++;
            xActual = fila;
            yActual = columna;
            puntuacion += 100;
            return true;
        }

        if (esMovimientoValido(fila, columna)) {
            tablero[fila][columna] = paso++;
            xActual = fila;
            yActual = columna;
            puntuacion += 100;
            return true;
        } else {
            errores++;
            return false;
        }
    }

    /** Verifica si el movimiento del caballo es válido */
    public boolean esMovimientoValido(int fila, int columna) {
        if (fila < 0 || fila >= N || columna < 0 || columna >= N) return false;
        if (tablero[fila][columna] != -1) return false;
        if (xActual == -1 && yActual == -1) return true; // primer clic
        int dx = Math.abs(fila - xActual);
        int dy = Math.abs(columna - yActual);
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }

    /** Verifica si el juego está ganado (todos los cuadros ocupados) */
    public boolean haGanado() {
        return paso == N * N;
    }

    /** Devuelve el tablero como array 1D para el frontend */
    public int[] getTablero() {
        int[] plano = new int[N * N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                plano[i * N + j] = tablero[i][j];
        return plano;
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
}
