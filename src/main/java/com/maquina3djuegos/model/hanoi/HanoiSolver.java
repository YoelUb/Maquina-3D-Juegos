package com.maquina3djuegos.model.hanoi;

public class HanoiSolver {

    private int movimientos;

    public void resolver(int n, char origen, char auxiliar, char destino) {
        movimientos = 0;
        System.out.println("Resolviendo Torres de Hanoi con " + n + " discos:\n");
        mover(n, origen, auxiliar, destino);
        System.out.println("\nTotal de movimientos: " + movimientos);
    }

    private void mover(int n, char origen, char auxiliar, char destino) {
        if (n == 1) {
            mostrarMovimiento(origen, destino);
            movimientos++;
        } else {
            mover(n - 1, origen, destino, auxiliar);
            mostrarMovimiento(origen, destino);
            movimientos++;
            mover(n - 1, auxiliar, origen, destino);
        }
    }

    private void mostrarMovimiento(char desde, char hacia) {
        System.out.println("Mover disco de " + desde + " a " + hacia);
    }

    public int getMovimientos() {
        return movimientos;
    }
}
