package com.maquina3djuegos.controller;

import com.maquina3djuegos.persistence.ResultadoDAO;
import com.maquina3djuegos.persistence.ResultadoPartida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/marcadores")
public class MarcadorController {

    private final ResultadoDAO resultadoDAO;

    @Autowired
    public MarcadorController(ResultadoDAO resultadoDAO) {
        this.resultadoDAO = resultadoDAO;
    }

    /**
     * Guarda un nuevo resultado para el juego indicado.
     */
    @PostMapping("/{juego}")
    public ResponseEntity<Void> guardaResultado(
            @PathVariable("juego") String juego,
            @RequestBody SaveResultadoDTO dto
    ) {
        ResultadoPartida r = new ResultadoPartida();
        r.setTipoJuego(juego);
        r.setJugador(dto.getJugador());
        r.setParametroInicial(dto.getParametroInicial());
        r.setPuntuacion(dto.getPuntuacion());
        r.setDuracionMs(dto.getDuracionMs());
        r.setMovimientos(dto.getMovimientos());
        r.setExito(true);
        r.setFecha(LocalDateTime.now());

        resultadoDAO.guardarResultado(r);
        return ResponseEntity.ok().build();
    }

    /**
     * Devuelve el Top 10 de resultados para el juego indicado.
     */
    @GetMapping("/{juego}")
    public ResponseEntity<List<ResultadoPartida>> top10(
            @PathVariable("juego") String juego
    ) {
        List<ResultadoPartida> lista = resultadoDAO.obtenerTop10(juego);
        return ResponseEntity.ok(lista);
    }


    public static class SaveResultadoDTO {
        private String jugador;
        private int parametroInicial;
        private int puntuacion;
        private long duracionMs;
        private int movimientos;

        public String getJugador() { return jugador; }
        public void setJugador(String jugador) { this.jugador = jugador; }
        public int getParametroInicial() { return parametroInicial; }
        public void setParametroInicial(int parametroInicial) { this.parametroInicial = parametroInicial; }
        public int getPuntuacion() { return puntuacion; }
        public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }
        public long getDuracionMs() { return duracionMs; }
        public void setDuracionMs(long duracionMs) { this.duracionMs = duracionMs; }
        public int getMovimientos() { return movimientos; }
        public void setMovimientos(int movimientos) { this.movimientos = movimientos; }
    }
}
