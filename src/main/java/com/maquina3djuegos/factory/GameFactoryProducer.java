package com.maquina3djuegos.factory;

public class GameFactoryProducer {

    public static JuegoFactory getFactory(String tipoJuego) {

        return switch (tipoJuego.toUpperCase()) {

            case "NREINAS" -> new NReinasFactory();
            case "CABALLO" -> new CaballoFactory();
            case "HANOI" -> new HanoiFactory();
            default -> throw new IllegalArgumentException("Tipo de juego no soportado: " + tipoJuego);

        };
    }
}