package entidades;

import java.util.Date;
import enums.PagamentoEnum;

public class Pagamento {
    private long id;
    private PagamentoEnum formaPagamento;
    private String nomeResponsavelChekin;
    private double valor;
    private String status;
    private Date dataVencimento;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PagamentoEnum getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(PagamentoEnum formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getNomeResponsavelChekin() {
        return nomeResponsavelChekin;
    }

    public void setNomeResponsavelChekin(String nomeResponsavelChekin) {
        this.nomeResponsavelChekin = nomeResponsavelChekin;
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
