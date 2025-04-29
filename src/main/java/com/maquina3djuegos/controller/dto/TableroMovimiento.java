package com.maquina3djuegos.controller.dto;

public class TableroMovimiento {
    private int fila;
    private int columna;
    private int[] tablero;
    private int puntuacion;
    private int errores;

    public TableroMovimiento() {}

    public int getFila() { return fila; }
    public void setFila(int fila) { this.fila = fila; }

    public int getColumna() { return columna; }
    public void setColumna(int columna) { this.columna = columna; }

    public int[] getTablero() { return tablero; }        // getter 1D
    public void setTablero(int[] tablero) { this.tablero = tablero; }  // setter 1D

    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }

    public int getErrores() { return errores; }
    public void setErrores(int errores) { this.errores = errores; }
}
