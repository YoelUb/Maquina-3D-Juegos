package com.maquina3djuegos.controller;

import com.maquina3djuegos.controller.dto.JuegoResponse;
import com.maquina3djuegos.controller.dto.TableroMovimiento;
import com.maquina3djuegos.model.reinas.ReinasSolver;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nreinas")
public class JuegosController {

    @PostMapping("/jugar")
    public JuegoResponse jugar(@RequestBody TableroMovimiento mov) {
        // Estado actual 1D del tablero recibido
        int[] estado1D = mov.getTablero();
        int n = estado1D.length;

        // Inicializar solver con el estado recibido
        ReinasSolver solver = new ReinasSolver(n);
        solver.cargarTablero(estado1D);

        // Ejecutar jugada
        boolean valido = solver.jugar(mov.getFila(), mov.getColumna());

        // Acumular puntos y errores
        int newPuntuacion = mov.getPuntuacion() + (valido ? 10 : -5);
        int newErrores   = mov.getErrores()   + (valido ?  0 :  1);

        // Obtener nuevo estado 1D del solver
        int[] nuevo1D = solver.getTablero();

        // Devolver respuesta con estado actualizado
        return new JuegoResponse(
                valido,
                newPuntuacion,
                newErrores,
                solver.haGanado(),
                nuevo1D
        );
    }

    @GetMapping("/reset")
    public String reset() {
        return "Ok";
    }
}
