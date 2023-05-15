package teste;

import entidades.Pagamento;
import enums.PagamentoEnum;
import repositorios.PagamentoRepositorio;
import servicos.PagamentoServico;

import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TestePagamento {

    public static void main(String[] args) throws SQLException {

        PagamentoServico pagamentoServico = new PagamentoServico();

        // Inserção
        /*
        Pagamento pagamento1 = new Pagamento();

        pagamento1.setFormaPagamento(PagamentoEnum.Avista);
        pagamento1.setValor(2000);
        pagamento1.setStatus("Não pago");
        pagamento1.setDataVencimento(LocalDate.of(2023, 10,10));
        pagamento1.setIdHospede(1);

        pagamentoServico.salvar(pagamento1);
        */

        // Busca
        /*
        List<Pagamento> pagamentos = PagamentoRepositorio.getInstance().listar();

        for (Pagamento pagamento : pagamentos){
            System.out.println("ID: "+pagamento.getId());
            System.out.println("FORMA PAGAMENTO: "+pagamento.getFormaPagamento().getDescricao());
            System.out.printf("VALOR: R$%,3.2f\n", pagamento.getValor());
            System.out.println("STATUS: "+pagamento.getStatus());
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.println("VENCIMENTO: "+pagamento.getDataVencimento().format(formato));
            System.out.println("ID_HOSPEDE: "+pagamento.getIdHospede());
        }
        */

        // Atualização
        /*
        Pagamento pagamento2 = new Pagamento();

        pagamento2.setFormaPagamento(PagamentoEnum.Credito);
        pagamento2.setValor(2000);
        pagamento2.setStatus("Não pago");
        pagamento2.setDataVencimento(LocalDate.of(2023, 10,10));
        pagamento2.setIdHospede(1);

        pagamentoServico.alterar(1, pagamento2);
        */

        // Exclusão
        /*
        pagamentoServico.deletarPorId(1);
        */
    }
}
