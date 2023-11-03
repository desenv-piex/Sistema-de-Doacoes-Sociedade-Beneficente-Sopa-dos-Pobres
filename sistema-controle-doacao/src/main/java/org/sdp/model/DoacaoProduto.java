package org.sdp.model;

import javax.persistence.*;

@Entity
@Table(name = "doacao_produto")
public class DoacaoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doacao_id")
    private Doacao doacao;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private int quantidade;

    public DoacaoProduto(Long id, Doacao doacao, Produto produto, int quantidade) {
        this.id = id;
        this.doacao = doacao;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public DoacaoProduto() {
    }

    public Long getId() {
        return id;
    }

    public Doacao getDoacao() {
        return doacao;
    }

    public void setDoacao(Doacao doacao) {
        this.doacao = doacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}