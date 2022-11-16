package entidades;

import java.util.Date;
import enums.Pagamento;

public class Pagamentos {
    private long id;
    private Pagamento formaPagamento;
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

    public Pagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Pagamento formaPagamento) {
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
