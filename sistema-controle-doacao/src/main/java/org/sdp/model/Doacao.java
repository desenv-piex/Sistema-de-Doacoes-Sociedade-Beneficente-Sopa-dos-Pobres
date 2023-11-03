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

    //@ManyToMany
    //@JoinTable(name = "doacao_produto",
    //        joinColumns = @JoinColumn(name = "doacao_id"),
    //        inverseJoinColumns = @JoinColumn(name = "produto_id"))

    @OneToMany(mappedBy = "doacao")
    private List<DoacaoProduto> produtos;

    @Temporal(TemporalType.TIMESTAMP) // Mapeia o atributo de data como LocalDateTime
    @Column(name = "data_doacao") // Nome da coluna no banco de dados
    private Date dataDoacao;

    @Column(name = "valor_doacao")
    private double valorDoacao;

    public Doacao() {
        this.produtos = new ArrayList<>();
    }

    public Doacao(Long id, ETipoDoacao tipoDoacao, List<DoacaoProduto> produtos, Date dataDoacao, double valorDoacao) {
        this.id = id;
        this.tipoDoacao = tipoDoacao;
        this.produtos = produtos;
        this.dataDoacao = dataDoacao;
        this.valorDoacao = valorDoacao;
    }

    public double getValorDoacao() {
        return valorDoacao;
    }

    public void setValorDoacao() {
        this.valorDoacao = valorTotalDoado();
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


    public Date getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(Date dataDoacao) {
        this.dataDoacao = dataDoacao;
    }

    public List<DoacaoProduto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<DoacaoProduto> produtos) {
        this.produtos = produtos;
    }

    public double valorTotalDoado(){
        double valTot = 0;

        if (tipoDoacao.equals(ETipoDoacao.Produtos)){
           for (DoacaoProduto produto : produtos) {
                valTot += produto.getProduto().getValorProduto() * produto.getQuantidade();
           }
        } else {
            valTot = this.valorDoacao;
        }
        return valTot;
    }

}
