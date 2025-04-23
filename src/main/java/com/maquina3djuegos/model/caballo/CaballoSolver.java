package com.maquina3djuegos.model.caballo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CaballoSolver {
    private final int N = 8;
    private final int[] movX = {2, 1, -1, -2, -2, -1, 1, 2};
    private final int[] movY = {1, 2, 2, 1, -1, -2, -2, -1};

    public void resolver(int xInicial, int yInicial) {
        int[][] tablero = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                tablero[i][j] = -1;

        tablero[xInicial][yInicial] = 0;

        if (resolverRecursivo(xInicial, yInicial, 1, tablero)) {
            imprimirTablero(tablero);
        } else {
            System.out.println("No se encontró recorrido completo.");
        }
    }

    private boolean resolverRecursivo(int x, int y, int paso, int[][] tablero) {
        if (paso == N * N) return true;

        List<int[]> movimientos = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int nx = x + movX[i];
            int ny = y + movY[i];
            if (esValido(nx, ny, tablero)) {
                int grado = contarMovimientosValidos(nx, ny, tablero);
                movimientos.add(new int[]{nx, ny, grado});
            }
        }

        // Ordenar movimientos por la cantidad de futuros movimientos disponibles (Warnsdorff)
        movimientos.sort(Comparator.comparingInt(a -> a[2]));

        for (int[] mov : movimientos) {
            int nx = mov[0], ny = mov[1];
            tablero[nx][ny] = paso;
            if (resolverRecursivo(nx, ny, paso + 1, tablero))
                return true;
            tablero[nx][ny] = -1; // backtrack
        }

        return false;
    }

    private int contarMovimientosValidos(int x, int y, int[][] tablero) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + movX[i];
            int ny = y + movY[i];
            if (esValido(nx, ny, tablero)) count++;
        }
        return count;
    }

    private boolean esValido(int x, int y, int[][] tablero) {
        return x >= 0 && y >= 0 && x < N && y < N && tablero[x][y] == -1;
    }

    private void imprimirTablero(int[][] tablero) {
        for (int[] fila : tablero) {
            for (int celda : fila) {
                System.out.printf("%2d ", celda);
            }
            System.out.println();
        }
    }
}
