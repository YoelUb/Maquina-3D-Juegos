package com.maquina3djuegos.controller;

import com.maquina3djuegos.controller.dto.HanoiMovimiento;
import com.maquina3djuegos.controller.dto.HanoiResponse;
import com.maquina3djuegos.model.hanoi.HanoiSolverVisual;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hanoi")
public class HanoiController {

    @PostMapping("/jugar")
    public HanoiResponse jugar(@RequestBody HanoiMovimiento mov) {
        int discos = mov.getEstado().length / 3;
        HanoiSolverVisual solver = new HanoiSolverVisual(discos);
        solver.cargarEstado(mov.getEstado());

        solver.setPuntuacion(mov.getPuntuacion());
        solver.setErrores(mov.getErrores());

        boolean valido = solver.moverDisco(mov.getOrigen(), mov.getDestino());
        boolean ganado = solver.haGanado();
        int[] nuevoEstado = solver.obtenerEstado();

        return new HanoiResponse(
                valido,
                solver.getPuntuacion(),
                solver.getErrores(),
                ganado,
                nuevoEstado
        );
    }

    @GetMapping("/reset")
    public String reset() {
        return "Ok";
    }
}
