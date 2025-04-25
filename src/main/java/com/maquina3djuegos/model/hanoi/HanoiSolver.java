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

    public String resolverComoTexto(int n, char origen, char auxiliar, char destino) {
        movimientos = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("Resolviendo Torres de Hanoi con ").append(n).append(" discos:\n\n");
        moverComoTexto(n, origen, auxiliar, destino, sb);
        sb.append("\nTotal de movimientos: ").append(movimientos).append("\n");
        return sb.toString();
    }

    private void moverComoTexto(int n, char origen, char auxiliar, char destino, StringBuilder sb) {
        if (n == 1) {
            sb.append("Mover disco de ").append(origen).append(" a ").append(destino).append("\n");
            movimientos++;
        } else {
            moverComoTexto(n - 1, origen, destino, auxiliar, sb);
            sb.append("Mover disco de ").append(origen).append(" a ").append(destino).append("\n");
            movimientos++;
            moverComoTexto(n - 1, auxiliar, origen, destino, sb);
        }
    }


    private void mostrarMovimiento(char desde, char hacia) {
        System.out.println("Mover disco de " + desde + " a " + hacia);
    }

    public int getMovimientos() {
        return movimientos;
    }
}
