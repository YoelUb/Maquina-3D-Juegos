package com.maquina3djuegos.service;

import com.maquina3djuegos.model.reinas.ReinasSolver;
import com.maquina3djuegos.model.caballo.CaballoSolver;
import com.maquina3djuegos.model.hanoi.HanoiSolver;
import com.maquina3djuegos.persistence.ResultadoDAO;
import com.maquina3djuegos.persistence.ResultadoPartida;
import org.springframework.stereotype.Service;

@Service
public class JuegoService {
    private final ResultadoDAO dao = new ResultadoDAO();

    public String resolverNReinas(int n) {
        ReinasSolver solver = new ReinasSolver();
        String tablero = solver.resolverComoTexto(n);
        boolean exito = !tablero.contains("No se encontró");
        int movs = exito ? n : 0; // podrías ajustar con conteo real si lo expones
        dao.guardar(new ResultadoPartida("NREINAS", n, exito, movs));
        return tablero;
    }

    public String resolverCaballo(int x, int y) {
        CaballoSolver solver = new CaballoSolver();
        String recorrido = solver.resolverComoTexto(x, y);
        boolean exito = !recorrido.contains("No se encontró");
        int movs = exito ? 64 - 1 : 0;
        dao.guardar(new ResultadoPartida("CABALLO", x * 8 + y, exito, movs));
        return recorrido;
    }

    public String resolverHanoi(int discos) {
        HanoiSolver solver = new HanoiSolver();
        String pasos = solver.resolverComoTexto(discos, 'A', 'B', 'C');
        boolean exito = solver.getMovimientos() == (int)Math.pow(2, discos) - 1;
        int movs = solver.getMovimientos();
        dao.guardar(new ResultadoPartida("HANOI", discos, exito, movs));
        return pasos;
    }
}
