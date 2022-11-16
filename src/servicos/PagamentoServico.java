package servicos;

import entidades.Pagamento;
import enums.PagamentoEnum;
import interfaces.servico.IBasicoServico;
import repositorios.PagamentoRepositorio;

import java.util.Date;
import java.util.List;

public class PagamentoServico implements IBasicoServico<Pagamento> {

    public void  registrar(long id, PagamentoEnum formaPagamento,
                           String nomeResposavelChekin, double valor, String status, Date dataCompra){
        try {
            Pagamento novoPagamento = new Pagamento();
            novoPagamento.setFormaPagamento(formaPagamento);
            novoPagamento.setValor(valor);
            novoPagamento.setStatus(status);
            novoPagamento.setNomeResposavelChekin(nomeResposavelChekin);

            PagamentoRepositorio.getInstance().salvar(novoPagamento);
        }catch (Exception e){
            System.out.println("Error:"+e.getMessage());
        }

    }

    @Override
    public void salvar(Pagamento usuario) {

    }

    @Override
    public void alterar(int index, Pagamento usuario) {

    }

    @Override
    public void deletarPorId(long id) {
        IBasicoServico.super.deletarPorId(id);
    }

    @Override
    public List<Pagamento> listar() {
        return null;
    }
}
