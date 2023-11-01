package org.sdp;


import org.sdp.database.dao.UsuarioDao;
import org.sdp.model.Usuario;
import org.sdp.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

public class Main {
    public static void main(String[] args) {

        Usuario teste = new Usuario("teste","123");

        try{
            new UsuarioDao().cadastrar(teste);


        } catch (PersistenceException e) {
            System.out.println("ERRRO: " + e.getMessage());
            throw new RuntimeException(e);
        }

    }
}