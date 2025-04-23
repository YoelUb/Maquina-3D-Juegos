package com.maquina3djuegos.model.reinas;

import com.maquina3djuegos.model.Juego;
import java.util.Scanner;

public class NReinas implements Juego {

    @Override
    public void iniciarJuego() {
        System.out.println("== N Reinas ==");
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el valor de N: ");
        int n = sc.nextInt();
        ReinasSolver solver = new ReinasSolver();
        solver.resolver(n);
    }

}
