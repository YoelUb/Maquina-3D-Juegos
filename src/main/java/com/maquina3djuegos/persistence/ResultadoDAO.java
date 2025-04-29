package com.maquina3djuegos.persistence;

import com.maquina3djuegos.persistence.ResultadoPartida;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ResultadoDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Guarda un nuevo resultado de partida en la base de datos.
     */
    @Transactional
    public void guardarResultado(ResultadoPartida resultado) {
        em.persist(resultado);
    }

    /**
     * Recupera el Top 10 de resultados para un juego.
     * - En 'hanoi' se ordena por movimientos ASC (menos movimientos = mejor)
     * - En los demás, se ordena por puntuación DESC (más puntuación = mejor)
     */
    @Transactional(readOnly = true)
    public List<ResultadoPartida> obtenerTop10(String tipoJuego) {
        String query;
        if ("hanoi".equalsIgnoreCase(tipoJuego)) {
            query = "SELECT r FROM ResultadoPartida r " +
                    "WHERE r.tipoJuego = :tipo " +
                    "ORDER BY r.movimientos ASC, r.duracionMs ASC";
        } else {
            query = "SELECT r FROM ResultadoPartida r " +
                    "WHERE r.tipoJuego = :tipo " +
                    "ORDER BY r.puntuacion DESC, r.duracionMs ASC";
        }

        return em.createQuery(query, ResultadoPartida.class)
                .setParameter("tipo", tipoJuego)
                .setMaxResults(10)
                .getResultList();
    }
}
