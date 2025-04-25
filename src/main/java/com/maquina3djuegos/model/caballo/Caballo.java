package com.maquina3djuegos.model.caballo;

import com.maquina3djuegos.model.Juego;

import java.util.Scanner;

public class Caballo implements Juego {

    @Override
    public void iniciarJuego() {
        System.out.println("== Recorrido del Caballo ==");
        Scanner sc = new Scanner(System.in);
        System.out.print("Fila inicial (1-8): ");
        int fila = sc.nextInt() - 1;
        System.out.print("Columna inicial (1-8): ");
        int col =  sc.nextInt() - 1 ;
        CaballoSolver solver = new CaballoSolver();
        solver.resolver(fila, col);
    }


}
