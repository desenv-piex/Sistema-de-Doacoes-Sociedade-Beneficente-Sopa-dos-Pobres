package org.sdp.database.dao.produto;

import org.sdp.database.dao.IGenericDAO;
import org.sdp.model.Produto;
import org.sdp.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao implements IGenericDAO<Produto, Long> {

    private final EntityManager em;


    public ProdutoDao(){
        this.em = JPAUtil.getEntityManager();
    }

    @Override
    public void cadastrar(Produto Produto) throws PersistenceException {
        try{
            this.em.getTransaction().begin();
            this.em.persist(Produto);
            this.em.getTransaction().commit(); // Confirma a transação
        } catch (PersistenceException e) {
            this.em.getTransaction().rollback();
            throw e;
        } finally {
            this.em.close();
        }
    }

    @Override
    public void atualizar(Produto Produto) throws PersistenceException {
        this.em.merge(Produto);
    }

    @Override
    public void remover(Produto Produto) throws PersistenceException {
        try{
            this.em.getTransaction().begin();

            Produto = em.merge(Produto);
            this.em.remove(Produto);

            this.em.getTransaction().commit(); // Confirma a transação
        } catch (PersistenceException e) {
            this.em.getTransaction().rollback();
            throw e;
        } finally {
            this.em.close();
        }
    }

    @Override
    public Produto buscar(Long id) throws PersistenceException {
        Produto u = new Produto();
        try{
            this.em.getTransaction().begin();

            u = em.find(Produto.class, id);

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
    public List<Produto> buscarTodos() throws PersistenceException {
        List<Produto> produtos = new ArrayList<>();
        try{
            this.em.getTransaction().begin();

            String jpql = "SELECT p FROM Produto p";
            produtos = em.createQuery(jpql, Produto.class).getResultList();

            this.em.getTransaction().commit(); // Confirma a transação
        } catch (PersistenceException e) {
            this.em.getTransaction().rollback();
            throw e;
        } finally {
            this.em.close();
        }


        return produtos;
    }

    public List<Produto> buscarPorNomeProduto(String nomeProduto){
        String jpql = "SELECT p FROM Produto p WHERE p.nomeProduto = :nomeProduto";
        return em.createQuery(jpql, Produto.class)
                .setParameter("nomeProduto", nomeProduto)
                .getResultList();
    }

}
