package com.maquina3djuegos.controller.dto;

public class HanoiResponse {
    private boolean valido;
    private int puntuacion;
    private int errores;
    private boolean ganado;
    private int[] estado;

    public HanoiResponse(boolean valido, int puntuacion, int errores, boolean ganado, int[] estado) {
        this.valido = valido;
        this.puntuacion = puntuacion;
        this.errores = errores;
        this.ganado = ganado;
        this.estado = estado;
    }

    public boolean isValido() {
        return valido;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public int getErrores() {
        return errores;
    }

    public boolean isGanado() {
        return ganado;
    }

    public int[] getEstado() {
        return estado;
    }
}
