package com.maquina3djuegos.controller;

import com.maquina3djuegos.controller.dto.JuegoResponse;
import com.maquina3djuegos.controller.dto.TableroMovimiento;
import com.maquina3djuegos.model.caballo.CaballoSolver;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/caballo")
public class CaballoController {

    @PostMapping("/jugar")
    public JuegoResponse jugar(@RequestBody TableroMovimiento mov) {
        int[] estado1D = mov.getTablero();
        int n = (int) Math.sqrt(estado1D.length);

        CaballoSolver solver = new CaballoSolver();
        solver.cargarTablero(estado1D);
        solver.setPuntuacion(mov.getPuntuacion());
        solver.setErrores(mov.getErrores());

        boolean valido = solver.jugar(mov.getFila(), mov.getColumna());
        int[] nuevo1D = solver.getTablero();
        boolean ganado = solver.haGanado();

        boolean sinMovimientos = true;
        if (!ganado) {
            for (int fila = 0; fila < n && sinMovimientos; fila++) {
                for (int col = 0; col < n; col++) {
                    if (nuevo1D[fila * n + col] == -1 && solver.esMovimientoValido(fila, col)) {
                        sinMovimientos = false;
                        break;
                    }
                }
            }
        }

        return new JuegoResponse(
                valido,
                solver.getPuntuacion(),
                solver.getErrores(),
                ganado,
                sinMovimientos,
                nuevo1D
        );
    }

    @GetMapping("/reset")
    public String reset() {
        return "Ok";
    }
}
