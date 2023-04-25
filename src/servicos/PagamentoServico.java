package servicos;

import entidades.Pagamento;
import enums.PagamentoEnum;
import interfaces.servico.IBasicoServico;
import repositorios.PagamentoRepositorio;

import java.util.Date;
import java.util.List;

public class PagamentoServico implements IBasicoServico<Pagamento> {

    public void sslvar(long id, PagamentoEnum formaPagamento,
                       String nomeResposavelChekin, double valor, String status, Date dataVencimento){
        try {
            Pagamento novoPagamento = new Pagamento();
            novoPagamento.setFormaPagamento(formaPagamento);
            novoPagamento.setValor(valor);
            novoPagamento.setStatus(status);
            novoPagamento.setNomeResponsavelChekin(nomeResposavelChekin);

            PagamentoRepositorio.getInstance().salvar(novoPagamento);
        }catch (Exception e){
            System.out.println("Error:"+e.getMessage());
        }

    }

    @Override
    public void salvar(Pagamento pagamento) {
        PagamentoRepositorio.getInstance().salvar(pagamento);
    }

    @Override
    public void alterar(int id, Pagamento pagamento) {
        PagamentoRepositorio.getInstance().alterar(id, pagamento);
    }

    @Override
    public void deletarPorId(long id) {
        System.out.print("");
    }

    @Override
    public List<Pagamento> listar() {
        return null;
    }
}
