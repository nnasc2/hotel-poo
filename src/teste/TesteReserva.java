package teste;

import entidades.Reserva;
import repositorios.ReservaRepositorio;
import servicos.ReservaServico;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TesteReserva {

    public static void main(String[] args) throws SQLException {

        ReservaServico reservaServico = new ReservaServico();

        // Inserção
        /*
        Reserva reserva1 = new Reserva();

        reserva1.setIdHotel(1);
        reserva1.setIdHospede(1);
        reserva1.setNumQuarto(4);
        reserva1.setDataInicio(LocalDate.of(2023, 05, 10));
        reserva1.setDataFim(LocalDate.of(2023, 05, 13));
        reserva1.setDataCheckin(LocalDate.of(2023, 05, 10));
        reserva1.setDataCheckout(LocalDate.of(2023, 05, 13));
        reserva1.setValor(800);

        reservaServico.cadastrar(reserva1);
        */

        // Busca
        /*
        List<Reserva> reservas = ReservaRepositorio.getInstance().listar();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Reserva reserva : reservas){
            System.out.println("ID HOTEL: "+reserva.getIdHotel());
            System.out.println("ID HOSPEDE: "+reserva.getIdHospede());
            System.out.println("NÚMERO QUARTO: "+reserva.getNumQuarto());
            System.out.println("DATA INÍCIO: "+reserva.getDataInicio().format(formato));
            System.out.println("DATA FIM: "+reserva.getDataFim().format(formato));
            System.out.println("DATA CHECKING: "+reserva.getDataCheckin().format(formato));
            System.out.println("DATA CHECKOUT: "+reserva.getDataCheckout().format(formato));
            System.out.printf("VALOR: R$%,3.2f\n", reserva.getValor());
        }
         */

        // Atualização
        /*
        Reserva reserva2 = new Reserva();

        reserva2.setIdHotel(1);
        reserva2.setIdHospede(1);
        reserva2.setNumQuarto(4);
        reserva2.setDataInicio(LocalDate.of(2023, 05, 10));
        reserva2.setDataFim(LocalDate.of(2023, 05, 14));
        reserva2.setDataCheckin(LocalDate.of(2023, 05, 10));
        reserva2.setDataCheckout(LocalDate.of(2023, 05, 14));
        reserva2.setValor(900);

        reservaServico.alterar(1, reserva2);
        */

        // Exclusão
        /*
        reservaServico.deletar(1);
        */
    }
}
