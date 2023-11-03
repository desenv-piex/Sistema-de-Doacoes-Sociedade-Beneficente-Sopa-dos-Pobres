package org.sdp.database.dao.usuario;

import org.sdp.database.dao.IGenericDAO;
import org.sdp.model.Usuario;
import org.sdp.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao implements IGenericDAO<Usuario, Long> {

    private final EntityManager em;


    public UsuarioDao(){
        this.em = JPAUtil.getEntityManager();
    }

    @Override
    public void cadastrar(Usuario usuario) throws PersistenceException {
        try{
            this.em.getTransaction().begin();
            this.em.persist(usuario);
            this.em.getTransaction().commit(); // Confirma a transação
        } catch (PersistenceException e) {
            this.em.getTransaction().rollback();
            throw e;
        } finally {
            this.em.close();
        }
    }

    @Override
    public void atualizar(Usuario usuario) throws PersistenceException {
        //this.em.merge(usuario);
    }

    @Override
    public void remover(Usuario usuario) throws PersistenceException {
        try{
            this.em.getTransaction().begin();

            usuario = em.merge(usuario);
            this.em.remove(usuario);

            this.em.getTransaction().commit(); // Confirma a transação
        } catch (PersistenceException e) {
            this.em.getTransaction().rollback();
            throw e;
        } finally {
            this.em.close();
        }
    }

    @Override
    public Usuario buscar(Long id) throws PersistenceException {
        Usuario u = new Usuario();
        try{
            this.em.getTransaction().begin();

            u = em.find(Usuario.class, id);

            this.em.getTransaction().commit(); // Confirma a transação
        } catch (PersistenceException e) {
            this.em.getTransaction().rollback();
            throw e;
        } finally {
            this.em.close();
        }

        return u;
    }

    @Override
    public List<Usuario> buscarTodos() throws PersistenceException {
        String jpql = "SELECT u from Usuario u";
        //return em.createQuery(jpql, Usuario.class).getResultList();

        return new ArrayList<Usuario>();
    }

    public Usuario buscarPorLogineSenha(String login, String senha) {
        String jpql = "SELECT u from Usuario u where u.login = :login and u.senha = :senha";
        List<Usuario> user = em.createQuery(jpql, Usuario.class)
                .setParameter("login", login)
                .setParameter("senha", senha)
                .getResultList();

        if (user.isEmpty()) {
            return null;
        } else {
            return user.get(0);
        }
    }


    public List<Usuario> buscarPorLogin(String login){

        String jpql = "SELECT u from Usuario u where u.login = :login ";
        return em.createQuery(jpql, Usuario.class)
                .setParameter("login", login)
                .getResultList();

    }
}
