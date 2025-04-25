package com.maquina3djuegos.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ResultadoDAO {

    public void guardar(ResultadoPartida resultado) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(resultado);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}