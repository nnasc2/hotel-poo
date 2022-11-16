package repositorios;

import entidades.Pagamento;
import interfaces.repositorio.IRepositorioGenerico;

import java.util.ArrayList;
import java.util.List;

public class PagamentoRepositorio implements IRepositorioGenerico<Pagamento> {

    private static PagamentoRepositorio instance;
    List<Pagamento> listaPagamentos = new ArrayList<>();

    public static PagamentoRepositorio getInstance() {
        if (instance == null)
            instance = new PagamentoRepositorio();

        return instance;
    }



    @Override
    public boolean salvar(Pagamento pagamento) {
        //adicionando usuario a lista, tratamento de exceção utilizado foi o try/catch.//
        try {

            listaPagamentos.add(pagamento);
        } catch (Exception ex) {
            System.out.println (">>>Error:"+ Pagamento.class.getName() + "messager_error:" + ex.getMessage());
            ex.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean altera(int idPagamentos, Pagamento pagamento) {
        try{ if ( listaPagamentos.contains(idPagamentos)){
            listaPagamentos.set(idPagamentos, pagamento);
            return true;
        }
        }
        catch (Exception ex){
            System.out.println (">>>Error:"+ Pagamento.class.getName() + "messager_error:" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean deletarPorId(long idPagamentos) {
        try {
            if (listaPagamentos.contains(idPagamentos)) {
                listaPagamentos.remove(idPagamentos);
                return true;
            }
        } catch (Exception ex){
            System.out.println (">>>Error:"+ Pagamento.class.getName() + "messager_error:" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Pagamento> listar() {
        try{
            return this.listaPagamentos;
        } catch(Exception ex){
            System.out.println (">>>Error:"+ Pagamento.class.getName() + "messager_error:" + ex.getMessage());
            ex.printStackTrace();
            return new ArrayList<Pagamento>();
        }
    }
}
