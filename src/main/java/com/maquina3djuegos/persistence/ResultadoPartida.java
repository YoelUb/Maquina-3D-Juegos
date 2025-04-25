package com.maquina3djuegos.persistence;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "resultado_partida")
public class ResultadoPartida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoJuego;
    private int parametroInicial;
    private boolean exito;
    private int movimientos;
    private LocalDateTime fecha;

    public ResultadoPartida() {
        this.fecha = LocalDateTime.now();
    }

    public ResultadoPartida(String tipoJuego, int parametroInicial, boolean exito, int movimientos) {
        this.tipoJuego = tipoJuego;
        this.parametroInicial = parametroInicial;
        this.exito = exito;
        this.movimientos = movimientos;
        this.fecha = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() { return id; }
    public String getTipoJuego() { return tipoJuego; }
    public int getParametroInicial() { return parametroInicial; }
    public boolean isExito() { return exito; }
    public int getMovimientos() { return movimientos; }
    public LocalDateTime getFecha() { return fecha; }

    public void setTipoJuego(String tipoJuego) { this.tipoJuego = tipoJuego; }
    public void setParametroInicial(int parametroInicial) { this.parametroInicial = parametroInicial; }
    public void setExito(boolean exito) { this.exito = exito; }
    public void setMovimientos(int movimientos) { this.movimientos = movimientos; }
}