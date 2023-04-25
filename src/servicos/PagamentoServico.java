package servicos;

import entidades.Pagamento;
import enums.PagamentoEnum;
import interfaces.servico.IBasicoServico;
import repositorios.PagamentoRepositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PagamentoServico implements IBasicoServico<Pagamento> {

    public void salvar(long id, PagamentoEnum formaPagamento,
                       String nomeResposavelChekin, double valor, String status, Date dataVencimento){
        try {
            Pagamento novoPagamento = new Pagamento();
            novoPagamento.setFormaPagamento(formaPagamento);
            novoPagamento.setValor(valor);
            novoPagamento.setStatus(status);
            novoPagamento.setNomeResponsavelChekin(nomeResposavelChekin);

            PagamentoRepositorio.getInstance().salvar(novoPagamento);
        } catch (Exception e){
            System.out.println("Error:"+e.getMessage());
        }

    }

    @Override
    public void salvar(Pagamento pagamento) {
        try {
            PagamentoRepositorio.getInstance().salvar(pagamento);
        } catch (Exception e){
        System.out.println("Error:"+e.getMessage());
        }
    }

    @Override
    public void alterar(int id, Pagamento pagamento) {
        try {
            PagamentoRepositorio.getInstance().alterar(id, pagamento);
        } catch (Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }

    @Override
    public void deletarPorId(long id) {
        try {
            PagamentoRepositorio.getInstance().deletarPorId(id);
        } catch (Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }

    @Override
    public List<Pagamento> listar() {
        try {
            return PagamentoRepositorio.getInstance().listar();
        } catch (Exception e){
            System.out.println("Error:"+e.getMessage());
        }
        return null;
    }
}
