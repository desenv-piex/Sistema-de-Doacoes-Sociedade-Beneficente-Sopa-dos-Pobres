package org.sdp.database.dao.doacao;

import org.sdp.database.dao.IGenericDAO;
import org.sdp.model.Doacao;
import org.sdp.model.DoacaoProduto;
import org.sdp.model.Produto;
import org.sdp.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

public class DoacaoProdutoDao implements IGenericDAO<DoacaoProduto, Long> {

    private final EntityManager em;

    public DoacaoProdutoDao(){
        this.em = JPAUtil.getEntityManager();
    }

    @Override
    public void cadastrar(DoacaoProduto doacaoProduto) throws PersistenceException {
        try{
            this.em.getTransaction().begin();
            this.em.persist(doacaoProduto);
            this.em.getTransaction().commit(); // Confirma a transação
        } catch (PersistenceException e) {
            this.em.getTransaction().rollback();
            throw e;
        } finally {
            this.em.close();
        }
    }


    public void cadastrarList(List<DoacaoProduto> dps) throws PersistenceException {
        try{
            this.em.getTransaction().begin();

            for (DoacaoProduto doacaoProduto : dps) {
                this.em.persist(doacaoProduto);
            }

            this.em.getTransaction().commit(); // Confirma a transação
        } catch (PersistenceException e) {
            this.em.getTransaction().rollback();
            throw e;
        } finally {
            this.em.close();
        }
    }

    @Override
    public void atualizar(DoacaoProduto obj) throws PersistenceException {

    }

    @Override
    public void remover(DoacaoProduto obj) throws PersistenceException {

    }



    @Override
    public DoacaoProduto buscar(Long id) throws PersistenceException {
        DoacaoProduto u = new DoacaoProduto();
        try{
            this.em.getTransaction().begin();

            u = em.find(DoacaoProduto.class, id);

            this.em.getTransaction().commit(); // Confirma a transação
        } catch (PersistenceException e) {
            this.em.getTransaction().rollback();
            throw e;
        } finally {
            this.em.close();
        }

        return u;
    }
    public DoacaoProduto buscarPorIdDoacao(Long id) throws PersistenceException {
        DoacaoProduto u = new DoacaoProduto();
        try{
            this.em.getTransaction().begin();

            String jpql = "SELECT d FROM DoacaoProduto d WHERE doacao_id = :id";
            u = this.em.createQuery(jpql,DoacaoProduto.class).setParameter("id",id).getSingleResult();

            this.em.getTransaction().commit(); // Confirma a transação
        } catch (PersistenceException e) {
            this.em.getTransaction().rollback();
            throw e;
        } finally {
            this.em.close();
        }

        return u;
    }

    public List<DoacaoProduto> buscarListPorIdDoacao(Long id) throws PersistenceException {
        List<DoacaoProduto> u = new ArrayList<DoacaoProduto>();
        try{
            //this.em.getTransaction().begin();

            String jpql = "SELECT d FROM Doacao d WHERE doacao_id = :id";
            u = this.em.createQuery(jpql,DoacaoProduto.class).setParameter("id",id).getResultList();

            //this.em.getTransaction().commit(); // Confirma a transação
        } catch (PersistenceException e) {
            this.em.getTransaction().rollback();
            throw e;
        } finally {
            this.em.close();
        }

        return u;
    }

    public List<DoacaoProduto> buscarListPorIdProduto(Long id) throws PersistenceException {
        List<DoacaoProduto> u = new ArrayList<DoacaoProduto>();
        try{
            //this.em.getTransaction().begin();

            String jpql = "SELECT p FROM Produto p WHERE produto_id = :id";
            u = this.em.createQuery(jpql,DoacaoProduto.class).setParameter("id",id).getResultList();

            //this.em.getTransaction().commit(); // Confirma a transação
        } catch (PersistenceException e) {
            this.em.getTransaction().rollback();
            throw e;
        } finally {
            this.em.close();
        }

        return u;
    }

    @Override
    public List<DoacaoProduto> buscarTodos() throws PersistenceException {
        List<DoacaoProduto> doacaos = new ArrayList<>();
        try {
            String jpql = "SELECT d FROM Doacao d";
            doacaos = this.em.createQuery(jpql,DoacaoProduto.class).getResultList();
        }catch (PersistenceException e){
            throw e;
        }finally {
            this.em.close();
        }

        return  doacaos;
    }



}

