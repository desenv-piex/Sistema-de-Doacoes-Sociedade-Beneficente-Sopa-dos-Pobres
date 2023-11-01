package org.sdp;


import org.sdp.database.dao.produto.ProdutoDao;
import org.sdp.database.dao.usuario.UsuarioDao;
import org.sdp.model.Produto;
import org.sdp.model.Usuario;

import javax.persistence.PersistenceException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Usuario teste = new Usuario("teste","123");

        try{
            List<Produto> pu = new ProdutoDao().buscarTodos();
            pu.forEach(produto -> System.out.println(produto.getNomeProduto()));

            /*
            for (int i = 0; i < 5; i++) {
                Produto p = new Produto(null,"teste p " + i, 3, 2500.0);
                new ProdutoDao().cadastrar(p);
            }*/

        } catch (PersistenceException e) {
            System.out.println("ERRRO: " + e.getMessage());
            throw new RuntimeException(e);
        }



    }
}