package org.sdp;

import org.sdp.database.dao.UsuarioDao;
import org.sdp.model.Usuario;
import org.sdp.util.JPAUtil;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        UsuarioDao usuarioDao = new UsuarioDao(em);


        Usuario usuario = new Usuario("zezin","123");

        em.getTransaction().begin();
        Usuario u = usuarioDao.buscarPorId(1l);
        System.out.println("Login: " + u.getLogin() + " Senha: " + u.getSenha());
        em.getTransaction().commit();
        em.close();

    }
}