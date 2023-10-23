package org.sdp.model;


import org.sdp.model.e.ETipoDoacao;

import java.util.ArrayList;

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
                valTot = produto.getValorProduto()*produto.getQntProduto();
            }
        }
        return valTot;
    }

}
