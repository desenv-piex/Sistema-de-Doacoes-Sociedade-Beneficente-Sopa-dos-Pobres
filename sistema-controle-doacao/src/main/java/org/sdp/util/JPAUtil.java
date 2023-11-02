package org.sdp.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.swing.*;

public class JPAUtil {
    private static final String PERSISTENCE_UNIT_NAME = "MySqlDB"; // O nome da unidade de persistência que você configurou no arquivo persistence.xml

    private static EntityManagerFactory entityManagerFactory;

    static {
        try {
            // Inicializa o EntityManagerFactory usando a unidade de persistência definida no persistence.xml
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch (PersistenceException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar com o banco de dados. " + ex.getMessage());
            throw ex;
        }
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void close() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}