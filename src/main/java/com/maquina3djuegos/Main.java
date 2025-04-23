package com.maquina3djuegos;

import com.maquina3djuegos.factory.GameFactoryProducer;
import com.maquina3djuegos.factory.JuegoFactory;
import com.maquina3djuegos.model.Juego;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("=== TEST FACTORY + MODEL ===");
        System.out.println("1. N Reinas");
        System.out.println("2. Recorrido del Caballo");
        System.out.println("3. Torres de Hanoi");
        System.out.print("Selecciona un juego: ");
        String opcion = sc.nextLine();

        String tipoJuego = switch (opcion) {
            case "1" -> "NREINAS";
            case "2" -> "CABALLO";
            case "3" -> "HANOI";
            default -> null;
        };

        if (tipoJuego == null) {
            System.out.println("Opción inválida.");
            return;
        }

        // Usamos el patrón Factory
        JuegoFactory factory = GameFactoryProducer.getFactory(tipoJuego);
        Juego juego = factory.crearJuego();

        // Ejecutamos el juego
        juego.iniciarJuego();
    }
}
