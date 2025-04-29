package com.maquina3djuegos.controller;

import com.maquina3djuegos.controller.dto.JuegoResponse;
import com.maquina3djuegos.controller.dto.TableroMovimiento;
import com.maquina3djuegos.model.reinas.NReinas;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

@RestController
@RequestMapping("/api/nreinas")
@SessionScope
public class NReinasController {

    private NReinas juego = new NReinas();

    @PostMapping("/jugar")
    public JuegoResponse jugar(@RequestBody TableroMovimiento mov) {
        // Usa getFila() y getColumna() tal como los define tu DTO:
        boolean valido = juego.colocar(mov.getFila(), mov.getColumna());

        int puntuacion = 0;                      // si no la usas, déjala a cero
        int errores    = juego.getErrores();
        boolean ganado        = juego.esVictoria();
        boolean sinMovimientos = false;
        int[] estado = juego.getTablero1D();

        return new JuegoResponse(
                valido,
                puntuacion,
                errores,
                ganado,
                sinMovimientos,
                estado
        );
    }

    @GetMapping("/reset")
    public String reset() {
        juego = new NReinas();
        return "Ok";
    }
}
