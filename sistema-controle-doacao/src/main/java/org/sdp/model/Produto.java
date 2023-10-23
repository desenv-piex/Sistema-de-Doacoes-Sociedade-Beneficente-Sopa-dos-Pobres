package org.sdp.model;

public class Produto {
    private Long idProduto;
    private String nomeProduto;
    private int qntProduto;
    private double valorProduto;

    public Produto() {
    }

    public Produto(Long idProduto, String nomeProduto, int qntProduto, double valorProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.qntProduto = qntProduto;
        valorProduto = valorProduto;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
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
}
