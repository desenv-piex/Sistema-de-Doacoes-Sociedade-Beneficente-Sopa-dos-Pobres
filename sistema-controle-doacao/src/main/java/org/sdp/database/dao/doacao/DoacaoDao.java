package org.sdp.database.dao.doacao;

import org.sdp.database.dao.IGenericDAO;
import org.sdp.model.Doacao;
import org.sdp.model.Produto;
import org.sdp.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

public class DoacaoDao implements IGenericDAO<Doacao, Long> {

    private final EntityManager em;


    public DoacaoDao(){
        this.em = JPAUtil.getEntityManager();
    }

    @Override
    public void cadastrar(Doacao Doacao) throws PersistenceException {
        try{
            this.em.getTransaction().begin();
            this.em.persist(Doacao);
            this.em.getTransaction().commit(); // Confirma a transação
        } catch (PersistenceException e) {
            this.em.getTransaction().rollback();
            throw e;
        } finally {
            this.em.close();
        }
    }

    @Override
    public void atualizar(Doacao Doacao) throws PersistenceException {
        //this.em.merge(Doacao);
    }

    @Override
    public void remover(Doacao Doacao) throws PersistenceException {
        try{
            this.em.getTransaction().begin();

            Doacao = em.merge(Doacao);
            this.em.remove(Doacao);

            this.em.getTransaction().commit(); // Confirma a transação
        } catch (PersistenceException e) {
            this.em.getTransaction().rollback();
            throw e;
        } finally {
            this.em.close();
        }
    }

    @Override
    public Doacao buscar(Long id) throws PersistenceException {
        Doacao u = new Doacao();
        try{
            this.em.getTransaction().begin();

            u = em.find(Doacao.class, id);

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
    public List<Doacao> buscarTodos() throws PersistenceException {
        List<Doacao> doacaos = new ArrayList<>();
        try {
            String jpql = "SELECT d FROM Doacao d";
            doacaos = this.em.createQuery(jpql,Doacao.class).getResultList();
        }catch (PersistenceException e){
            throw e;
        }finally {
            this.em.close();
        }

        return  doacaos;
    }



}
