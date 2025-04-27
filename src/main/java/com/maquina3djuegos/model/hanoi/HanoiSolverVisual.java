package com.maquina3djuegos.model.hanoi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HanoiSolverVisual {

    private final List<Stack<Integer>> torres = new ArrayList<>();
    private int numDiscos;
    private int puntuacion;
    private int errores;

    public HanoiSolverVisual(int numDiscos) {
        this.numDiscos = numDiscos;
        for (int i = 0; i < 3; i++) {
            torres.add(new Stack<>());
        }
        reiniciar();
    }

    /** Reinicia el estado inicial: todos los discos en la primera torre */
    public void reiniciar() {
        for (Stack<Integer> torre : torres) {
            torre.clear();
        }
        for (int i = numDiscos; i >= 1; i--) {
            torres.get(0).push(i);
        }
        puntuacion = 0;
        errores = 0;
    }

    /** Carga el estado desde un array enviado por el cliente */
    public void cargarEstado(int[] estado) {
        for (Stack<Integer> torre : torres) {
            torre.clear();
        }
        int discos = estado[estado.length - 1];
        this.numDiscos = discos;
        for (int fila = 0; fila < discos; fila++) {
            for (int torre = 0; torre < 3; torre++) {
                int valor = estado[fila * 3 + torre];
                if (valor != -1) {
                    torres.get(torre).push(valor);
                }
            }
        }
    }

    /** Realiza el movimiento visual */
    public boolean moverDisco(int origen, int destino) {
        if (origen < 0 || origen > 2 || destino < 0 || destino > 2) {
            errores++;
            puntuacion -= 10;
            return false;
        }
        if (torres.get(origen).isEmpty()) {
            errores++;
            puntuacion -= 10;
            return false;
        }
        if (!torres.get(destino).isEmpty() && torres.get(destino).peek() < torres.get(origen).peek()) {
            errores++;
            puntuacion -= 10;
            return false;
        }

        int disco = torres.get(origen).pop();
        torres.get(destino).push(disco);
        puntuacion += 100;
        return true;
    }

    /** True si todos los discos están apilados en la tercera torre */
    public boolean haGanado() {
        return torres.get(2).size() == numDiscos;
    }

    /** Codifica el estado actual en un array 1D para el cliente */
    public int[] obtenerEstado() {
        int[] estado = new int[numDiscos * 3 + 1];
        for (int i = 0; i < estado.length - 1; i++) {
            estado[i] = -1;
        }
        estado[estado.length - 1] = numDiscos;

        for (int torre = 0; torre < 3; torre++) {
            Stack<Integer> pila = torres.get(torre);
            for (int nivel = 0; nivel < pila.size(); nivel++) {
                estado[(nivel) * 3 + torre] = pila.get(pila.size() - nivel - 1);
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
