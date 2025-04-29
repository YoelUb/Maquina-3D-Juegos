package com.maquina3djuegos.controller.dto;

public class HanoiMovimiento {
    private int origen;
    private int destino;
    private int[] estado;
    private int puntuacion;
    private int errores;

    public HanoiMovimiento() {
    }

    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public int[] getEstado() {
        return estado;
    }

    public void setEstado(int[] estado) {
        this.estado = estado;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }
}
