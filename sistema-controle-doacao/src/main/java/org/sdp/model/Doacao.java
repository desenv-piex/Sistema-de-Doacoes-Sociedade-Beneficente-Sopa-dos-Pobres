package org.sdp.model;


import org.sdp.model.e.ETipoDoacao;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "doacao") // Nome da tabela no banco de dados
public class Doacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) // Mapeia o enum como uma string (ou podemos usar EnumType.ORDINAL para mapear como um número)
    private ETipoDoacao tipoDoacao;

    @OneToMany(mappedBy = "doacao") // Mapeia o relacionamento entre Doacao e Produto
    private List<Produto> produtos;

    @Temporal(TemporalType.TIMESTAMP) // Mapeia o atributo de data como LocalDateTime
    @Column(name = "data_doacao") // Nome da coluna no banco de dados
    private Date dataDoacao;

    public Doacao() {
        this.produtos = new ArrayList<>();
    }

    public Doacao(Long id, ETipoDoacao tipoDoacao, List<Produto> produtos, Date dataDoacao) {
        this.id = id;
        this.tipoDoacao = tipoDoacao;
        this.produtos = produtos;
        this.dataDoacao = dataDoacao;
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

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Date getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(Date dataDoacao) {
        this.dataDoacao = dataDoacao;
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
