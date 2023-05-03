package entidades;

import java.time.LocalDate;

import enums.PagamentoEnum;

public class Pagamento {
    private long id;
    private PagamentoEnum formaPagamento;
    private long idHospede;
    private double valor;
    private String status;
    private LocalDate dataVencimento;

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

    public long getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(long idHospede) {
        this.idHospede = idHospede;
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

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
