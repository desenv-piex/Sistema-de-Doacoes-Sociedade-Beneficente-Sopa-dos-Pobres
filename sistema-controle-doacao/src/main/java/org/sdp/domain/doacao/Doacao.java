package org.sdp.domain.doacao;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import org.sdp.domain.produto.Produto;
import org.sdp.domain.e.ETipoDoacao;

import java.util.ArrayList;

<<<<<<< HEAD:sistema-controle-doacao/src/main/java/org/sdp/domain/doacao/Doacao.java
<<<<<<< HEAD:sistema-controle-doacao/src/main/java/org/sdp/model/Doacao.java
@Entity
@Table(name = "doacao") // Nome da tabela no banco de dados
=======

@Table(name = "doacoes")
@Entity(name = "Doacao")
@EqualsAndHashCode(of = "id")
>>>>>>> main:sistema-controle-doacao/src/main/java/org/sdp/domain/doacao/Doacao.java
=======
>>>>>>> parent of fc6a3ce (finalizando configuração e migrade do banco de dados usando hibernate):sistema-controle-doacao/src/main/java/org/sdp/model/Doacao.java
public class Doacao {
    private Long id;
    private ETipoDoacao tipoDoacao;
    private ArrayList<Produto> produtos;

    public Doacao() {
    }

    public Doacao(Long id, ETipoDoacao tipoDoacao, ArrayList<Produto> produtos) {
        this.id = id;
        this.tipoDoacao = tipoDoacao;
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ETipoDoacao getTipoDoacao() {
        return tipoDoacao;
    }

    public void setTipoDoacao(ETipoDoacao tipoDoacao) {
        this.tipoDoacao = tipoDoacao;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public double valorTotalDoado(){
        double valTot = 0;

        if (tipoDoacao.equals(ETipoDoacao.Dinheiro)){
            for (Produto produto:produtos) {
                valTot = produto.getValorProduto();
            }

        }else{
            for (Produto produto:produtos) {
                valTot = produto.getValorProduto()*produto.getValorProduto();
            }
        }
        return valTot;
    }

}
