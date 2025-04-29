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
        // colocación / retirada de reina
        boolean valido = juego.colocar(mov.getFila(), mov.getColumna());

        // recogemos estado interno
        int     puntuacion      = juego.getPuntuacion();
        int     errores         = juego.getErrores();
        boolean ganado          = juego.esVictoria();
        // si no hemos ganado, comprobamos si quedan movimientos posibles
        boolean sinMovimientos  = !ganado && calculaSinMovimientos();
        int[]   estado          = juego.getTablero1D();

        // devolvemos respuesta con todos los flags
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

    /**
     * Recorre cada fila vacía y prueba si existe alguna columna válida
     * para colocar una reina. Si no hay ninguna jugada legal, devolvemos true.
     */
    private boolean calculaSinMovimientos() {
        int size = 8;
        int[] t1d = juego.getTablero1D();
        for (int f = 0; f < size; f++) {
            if (t1d[f] != -1) {
                // ya hay reina en esta fila, seguimos a la siguiente
                continue;
            }
            // probamos cada columna en esta fila
            for (int c = 0; c < size; c++) {
                if (juego.esPosicionValida(f, c)) {
                    // hemos encontrado al menos un movimiento válido
                    return false;
                }
            }
        }
        // no quedó ninguna jugada posible
        return true;
    }
}
