package org.sdp;


import org.sdp.database.dao.produto.ProdutoDao;
import org.sdp.database.dao.usuario.UsuarioDao;
import org.sdp.model.Doacao;
import org.sdp.model.Produto;
import org.sdp.model.Usuario;
import org.sdp.model.e.ETipoDoacao;
import org.sdp.util.ExcelExporter;

import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
/*
        Usuario teste = new Usuario("teste","123");

        try{
            List<Produto> pu = new ProdutoDao().buscarTodos();
            pu.forEach(produto -> System.out.println(produto.getNomeProduto()));


            for (int i = 0; i < 5; i++) {
                Produto p = new Produto(null,"teste p " + i, 3, 2500.0);
                new ProdutoDao().cadastrar(p);
            }

        } catch (PersistenceException e) {
            System.out.println("ERRRO: " + e.getMessage());
            throw new RuntimeException(e);
        }
*/

        ExcelExporter exporter = new ExcelExporter();

        // Exemplo de uma lista de doacoes
        Produto produto1 = new Produto(1L, "Produto 1", 10, 19.99);
        Produto produto2 = new Produto(2L, "Produto 2", 5, 14.99);
        Doacao doacao1 = new Doacao(1L, ETipoDoacao.Dinheiro, List.of(produto1, produto2), new Date());

        Produto produto3 = new Produto(3L, "Produto 3", 8, 12.99);
        Produto produto4 = new Produto(4L, "Produto 4", 12, 9.99);
        Doacao doacao2 = new Doacao(2L, ETipoDoacao.Produtos, List.of(produto3, produto4), new Date());

        exporter.exportToExcel(List.of(doacao1, doacao2));
    }
}