package org.sdp.model;


import javax.persistence.*;

@Entity
@Table(name = "produto") // Nome da tabela no banco de dados
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_produto")
    private String nomeProduto;

    @Column(name = "qnt_produto")
    private int qntProduto;

    @Column(name = "valor_produto")
    private double valorProduto;

    @ManyToOne // Mapeia o relacionamento entre Produto e Doacao
    private Doacao doacao;

    public Produto() {
    }

    public Produto(Long id, String nomeProduto, int qntProduto, double valorProduto) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.qntProduto = qntProduto;
        this.valorProduto = valorProduto;
    }

    public Long getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQntProduto() {
        return qntProduto;
    }

    public void setQntProduto(int qntProduto) {
        this.qntProduto = qntProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        valorProduto = valorProduto;
    }

    public Doacao getDoacao() {
        return doacao;
    }

    public void setDoacao(Doacao doacao) {
        this.doacao = doacao;
    }
}
