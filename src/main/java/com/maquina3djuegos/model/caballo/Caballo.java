package com.maquina3djuegos.model.caballo;

import com.maquina3djuegos.model.Juego;

import java.util.Scanner;

public class Caballo implements Juego {

    @Override
    public void iniciarJuego() {
        System.out.println("== Recorrido del Caballo ==");
        Scanner sc = new Scanner(System.in);
        System.out.print("Fila inicial (0-indexado): ");
        int fila = sc.nextInt();
        System.out.print("Columna inicial (0-indexado): ");
        int col = sc.nextInt();
        CaballoSolver solver = new CaballoSolver();
        solver.resolver(fila, col);
    }


}
