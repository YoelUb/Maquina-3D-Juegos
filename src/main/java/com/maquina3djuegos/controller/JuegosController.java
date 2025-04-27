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
        int[] estado1D = mov.getTablero();
        int n = estado1D.length;

        ReinasSolver solver = new ReinasSolver(n);
        solver.cargarTablero(estado1D);

        solver.setPuntuacion(mov.getPuntuacion());
        solver.setErrores(mov.getErrores());

        boolean valido = solver.jugar(mov.getFila(), mov.getColumna());
        int[] nuevo1D  = solver.getTablero();
        boolean ganado = solver.haGanado();

        boolean sinMovimientos = false;
        if (!ganado) {
            for (int f = 0; f < n && !sinMovimientos; f++) {
                if (nuevo1D[f] == -1) {
                    for (int c = 0; c < n; c++) {
                        if (solver.esPosicionValida(f, c)) {
                            sinMovimientos = false;
                            break;
                        }
                        sinMovimientos = true;
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
}  // ✅ Aquí acaba la clase
