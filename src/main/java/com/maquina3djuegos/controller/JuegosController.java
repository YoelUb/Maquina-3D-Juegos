// JuegosController.java
package com.maquina3djuegos.controller;

import com.maquina3djuegos.model.caballo.Caballo;
import com.maquina3djuegos.model.hanoi.Hanoi;
import com.maquina3djuegos.model.reinas.NReinas;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JuegosController {

    @GetMapping("/api/caballo")
    public String cargarCaballo(
            @RequestParam(defaultValue = "8") int filas,
            @RequestParam(defaultValue = "8") int columnas) {
        Caballo caballo = new Caballo();
        caballo.iniciarJuego(filas, columnas);
        return "<div style='color: white; font-size: 14px; white-space: pre;'>"
                + caballo.mostrarResultado()
                + "</div>";
    }

    @GetMapping("/api/hanoi")
    public String cargarHanoi(@RequestParam(defaultValue = "3") int n) {
        Hanoi hanoi = new Hanoi();
        hanoi.iniciarJuego(n);
        return "<div style='color: white; font-size: 14px; white-space: pre;'>"
                + hanoi.mostrarResultado()
                + "</div>";
    }

    @GetMapping("/api/nreinas")
    public String cargarNReinas(@RequestParam(defaultValue = "8") int n) {
        NReinas reinas = new NReinas();
        reinas.iniciarJuego(n);
        return "<div style='color: white; font-size: 14px; white-space: pre;'>"
                + reinas.mostrarResultado()
                + "</div>";
    }
}