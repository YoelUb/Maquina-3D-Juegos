package com.maquina3djuegos.model.hanoi;

import java.util.Stack;

public class HanoiSolver {

    private Stack<Integer>[] torres;
    private int discos;
    private int puntuacion;
    private int errores;

    @SuppressWarnings("unchecked")
    public HanoiSolver(int discos) {
        this.discos = discos;
        torres = new Stack[3];
        for (int i = 0; i < 3; i++) {
            torres[i] = new Stack<>();
        }
        for (int i = discos; i >= 1; i--) {
            torres[0].push(i);
        }
        puntuacion = 0;
        errores = 0;
    }

    public boolean mover(int origen, int destino) {
        if (origen < 0 || origen > 2 || destino < 0 || destino > 2) {
            errores++;
            puntuacion -= 10;
            return false;
        }
        if (torres[origen].isEmpty()) {
            errores++;
            puntuacion -= 10;
            return false;
        }
        if (!torres[destino].isEmpty() && torres[origen].peek() > torres[destino].peek()) {
            errores++;
            puntuacion -= 10;
            return false;
        }
        torres[destino].push(torres[origen].pop());
        puntuacion += 100;
        return true;
    }

    public boolean haGanado() {
        return torres[2].size() == discos;
    }

    public int[][] getEstadoTorres() {
        int[][] estado = new int[3][discos];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < torres[i].size(); j++) {
                estado[i][j] = torres[i].get(j);
            }
        }
        return estado;
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
