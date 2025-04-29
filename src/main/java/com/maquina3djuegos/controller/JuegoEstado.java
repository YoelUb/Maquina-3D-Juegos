package com.maquina3djuegos.controller;

public class JuegoEstado {
    private boolean valido;
    private int puntuacion;
    private int errores;
    private boolean ganado;

    public JuegoEstado(boolean valido, int puntuacion, int errores, boolean ganado) {
        this.valido = valido;
        this.puntuacion = puntuacion;
        this.errores = errores;
        this.ganado = ganado;
    }

    public boolean isValido() { return valido; }
    public int getPuntuacion() { return puntuacion; }
    public int getErrores() { return errores; }
    public boolean isGanado() { return ganado; }
}
