package org.sdp.database.dao;

import javax.persistence.PersistenceException;
import java.sql.SQLException;
import java.util.List;

public interface IGenericDAO<C,K> {
    public void cadastrar(C obj) throws PersistenceException;
    public void atualizar(C obj) throws PersistenceException;
    public void remover(C obj) throws PersistenceException;
    public C buscar(K key) throws PersistenceException;
    public List<C> buscarTodos() throws PersistenceException;

}