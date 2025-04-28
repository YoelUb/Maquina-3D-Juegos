package com.maquina3djuegos.persistence;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resultado_partida")
public class ResultadoPartida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipoJuego;

    @Column(nullable = false)
    private int parametroInicial;

    /** Puntuación, con valor por defecto 0 para filas antiguas */
    @Column(
            name = "puntuacion",
            nullable = false,
            columnDefinition = "integer default 0"
    )
    private int puntuacion;

    /** Duración en milisegundos, con valor por defecto 0 */
    @Column(
            name = "duracion_ms",
            nullable = false,
            columnDefinition = "bigint default 0"
    )
    private long duracionMs;

    @Column(nullable = false)
    private boolean exito;

    @Column(nullable = false)
    private int movimientos;

    @Column(nullable = false)
    private LocalDateTime fecha;

    /** Nuevo: nombre del jugador */
    @Column(nullable = true, length = 100)
    private String jugador;

    public ResultadoPartida() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoJuego() {
        return tipoJuego;
    }

    public void setTipoJuego(String tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    public int getParametroInicial() {
        return parametroInicial;
    }

    public void setParametroInicial(int parametroInicial) {
        this.parametroInicial = parametroInicial;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public long getDuracionMs() {
        return duracionMs;
    }

    public void setDuracionMs(long duracionMs) {
        this.duracionMs = duracionMs;
    }

    public boolean isExito() {
        return exito;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }

    public int getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(int movimientos) {
        this.movimientos = movimientos;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }
}
