package com.maquina3djuegos.controller.dto;

public class JuegoResponse {
    private boolean valido;
    private int puntuacion;
    private int errores;
    private boolean ganado;
    private int[] tablero;  // 1D

    public JuegoResponse(boolean valido, int puntuacion, int errores, boolean ganado, int[] tablero) {
        this.valido = valido;
        this.puntuacion = puntuacion;
        this.errores = errores;
        this.ganado = ganado;
        this.tablero = tablero;
    }

    public boolean isValido() { return valido; }
    public int getPuntuacion() { return puntuacion; }
    public int getErrores() { return errores; }
    public boolean isGanado() { return ganado; }
    public int[] getTablero() { return tablero; }
}
