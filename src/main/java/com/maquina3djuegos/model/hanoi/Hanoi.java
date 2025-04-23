package com.maquina3djuegos.model.hanoi;

import com.maquina3djuegos.model.Juego;
import java.util.Scanner;

public class Hanoi implements Juego {

    @Override
    public void iniciarJuego() {
        System.out.println("== Torres de Hanoi ==");
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el número de discos: ");
        int discos = sc.nextInt();
        HanoiSolver solver = new HanoiSolver();
        solver.resolver(discos, 'A', 'B', 'C');
    }
}
