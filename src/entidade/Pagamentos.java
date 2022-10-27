package entidade;

import java.util.Date;

public class Pagamentos {
    private long id;
    private String formaPagamento;
    /*enum para forma de pagameto*/
    private String nomeResposavelChekin;
    private double valor;
    private String status;
    private Date dataVencimento ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getNomeResposavelChekin() {
        return nomeResposavelChekin;
    }

    public void setNomeResposavelChekin(String nomeResposavelChekin) {
        this.nomeResposavelChekin = nomeResposavelChekin;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
