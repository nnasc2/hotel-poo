import entidades.Hotel;
import entidades.Reserva;
import repositorios.HotelRepositorio;
import servicos.HotelServico;
import servicos.ReservaServico;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TesteMain {

    public static void main(String[] args) {

        Hotel hotel = new Hotel();
        hotel.setId(1234567);
        hotel.setEstado("Pernambuco");
        hotel.setCidade("Recife");
        hotel.setNome("Hotel da Praia Grande");

        Hotel hotel1 = new Hotel();
        hotel1.setEstado("Pernambuco");
        hotel1.setCidade("Limoeiro");
        hotel1.setNome("Hotel da Vila");

        Hotel hotel2 = new Hotel();
        hotel2.setEstado("Bahia");
        hotel2.setCidade("Salvador");
        hotel2.setNome("Hotel do Amigo João");

        Hotel hotel3 = new Hotel();
        hotel3.setEstado("Bahia");
        hotel3.setCidade("Feira de Santana");
        hotel3.setNome("Hotel do José");

        HotelServico hotelServico = new HotelServico();
        hotelServico.cadastrar(hotel);
        hotelServico.cadastrar(hotel1);
        //hotelServico.cadastrar(hotel2);
        hotelServico.cadastrar(hotel3);

        System.out.println("Antes: "+hotelServico.listar().get(0).getNome());
        System.out.println("Antes: "+hotelServico.listar().size());
        hotelServico.deletar(1234567);
        System.out.println("Depois: "+hotelServico.listar().get(0).getNome());
        System.out.println("Depois: "+hotelServico.listar().size());

        for(String cidade : hotelServico.listarCidadesPorEstado("Bahia")){
            System.out.println(cidade);
        };

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        do{
            int entrada = -1;
            continuar = true;
            System.out.println("#### SEJA BEM-VINDO! ####");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Para 1");
            System.out.println("2 - Para 2");
            System.out.println("3 - Para 3");
            System.out.println("0 - Para sair");
            try{
                entrada = Integer.parseInt(scanner.next());
            } catch(Exception ex) {
                System.out.println("Sua entrada foi inválida!");
            }

            switch(entrada){
                case 0:
                    continuar = false;
                    break;
                case 1:
                    do {
                        continuar = true;
                        System.out.println("Você entrou em 1");
                        System.out.println("Escolha uma opção:");
                        System.out.println("1 - Para 1");
                        System.out.println("2 - Para 2");
                        System.out.println("3 - Para 3");
                        System.out.println("0 - Para cancelar");
                        entrada = Integer.parseInt(scanner.next());

                        switch(entrada){
                            case 0:
                                continuar = false;
                                break;
                            case 1:
                                break;
                        }
                    } while(continuar);
                    continuar = true;
                    break;
                case 2:
                    System.out.println("Você entrou em 2");
                    do {
                        continuar = true;
                        System.out.println("Escolha uma opção:");
                        System.out.println("1 - Para 1");
                        System.out.println("2 - Para 2");
                        System.out.println("3 - Para 3");
                        System.out.println("0 - Para cancelar");
                        entrada = Integer.parseInt(scanner.next());

                        switch(entrada){
                            case 0:
                                continuar = false;
                                break;
                            case 1:
                                break;
                        }
                    } while(continuar);
                    continuar = true;
                    break;
                case 3:
                    System.out.println("Você entrou em 3");
                    do {
                        continuar = true;
                        System.out.println("Escolha uma opção:");
                        System.out.println("1 - Para 1");
                        System.out.println("2 - Para 2");
                        System.out.println("3 - Para 3");
                        System.out.println("0 - Para cancelar");
                        entrada = Integer.parseInt(scanner.next());

                        switch(entrada){
                            case 0:
                                continuar = false;
                                break;
                            case 1:
                                break;
                        }
                    } while(continuar);
                    continuar = true;
                    break;
            }

        } while(continuar);


        LocalDate data = LocalDate.of(2022,11,13);
        Month mês = Month.NOVEMBER;
        System.out.println(mês.getValue());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(data.format(formatter));
        LocalDate dataPassada = LocalDate.parse("13/11/2022", formatter);
        System.out.println(dataPassada);

        /*HotelRepositorio repositorioHotel = HotelRepositorio.getInstance();
        HotelRepositorio repositorioHotel2 = HotelRepositorio.getInstance();

        System.out.println(repositorioHotel);
        System.out.println(repositorioHotel2);

        repositorioHotel.retornar();
        HotelRepositorio.getInstance().retornar();*/

        LocalDate dataInicio = LocalDate.of(2022, 11, 15);
        LocalDate dataFim = LocalDate.of(2022, 11, 17);

        LocalDate dataInicio2 = LocalDate.of(2022, 11, 16);
        LocalDate dataFim3 = LocalDate.of(2022, 11, 18);



    }

}
