package org.sdp.database.dao.doacao;

import org.sdp.database.dao.IGenericDAO;
import org.sdp.model.Doacao;
import org.sdp.model.DoacaoProduto;
import org.sdp.model.Produto;
import org.sdp.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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

    public Doacao cadastrarComRetorno(Doacao doacao) throws PersistenceException {

        try{
            this.em.getTransaction().begin();
            this.em.persist(doacao);
            this.em.getTransaction().commit(); // Confirma a transação
            em.refresh(doacao);
        } catch (PersistenceException e) {
            this.em.getTransaction().rollback();
            throw e;
        } finally {
            this.em.close();
        }

        return doacao;
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

/*

    @Override
    public List<Doacao> buscarTodos() throws PersistenceException {
        List<Doacao> doacaos = new ArrayList<>();
        try {
            String jpql = "SELECT d FROM Doacao d";
            doacaos = this.em.createQuery(jpql,Doacao.class).getResultList();

            // Carregar a coleção produtos para cada doação antes de fechar a sessão
            for (Doacao doacao : doacaos) {
                //doacao.getProdutos().size(); // Isso carrega a coleção
                doacao.setProdutos(new DoacaoProdutoDao().buscarListPorIdDoacao(doacao.getId()));
            }

        }catch (PersistenceException e){
            throw e;
        }finally {
            this.em.close();
        }

        return  doacaos;
    }
*/
    @Override
    public List<Doacao> buscarTodos() {
        List<Doacao> doacaos = new ArrayList<>();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            String jpql = "SELECT DISTINCT d FROM Doacao d LEFT JOIN FETCH d.produtos";
            doacaos = em.createQuery(jpql, Doacao.class).getResultList();

            for (Doacao d : doacaos) {
                d.setValorDoacao();
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace(); // Trate a exceção apropriadamente, não apenas imprima.
        } finally {
            em.close();
        }

        return doacaos;
    }

}
