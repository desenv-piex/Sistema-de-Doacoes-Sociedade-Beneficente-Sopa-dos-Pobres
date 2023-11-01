package org.sdp.database.dao;

import org.sdp.model.Usuario;

import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioDao {

    private EntityManager em;


    public UsuarioDao(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Usuario usuario) {
        this.em.persist(usuario);
    }

    public void atualizar(Usuario usuario){
        this.em.merge(usuario);
    }
    public void remover(Usuario usuario){
        usuario = em.merge(usuario);
        this.em.remove(usuario);
    }

    public Usuario buscarPorId(Long id){
        return em.find(Usuario.class, id);
    }

    public List<Usuario> buscarTodos(){
        String jpql = "SELECT u from Usuario u";
        return em.createQuery(jpql, Usuario.class).getResultList();
    }

    public List<Usuario> buscarPorLogin(String login){
        String jpql = "SELECT u from Usuario u where u.login = :login";
        return em.createQuery(jpql, Usuario.class)
                .setParameter("login", login)
                .getResultList();
    }
}
