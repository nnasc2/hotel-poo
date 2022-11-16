import entidades.Hotel;
import entidades.Quarto;
import enums.Classificacao;
import servicos.HotelServico;
import servicos.QuartoServico;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        HotelServico hotelServico = new HotelServico();
        QuartoServico quartoServico = new QuartoServico();

        Hotel hotel1 = new Hotel();
        hotel1.setId(1111111);
        hotel1.setNome("Hotel");
        hotel1.setDescricao("");
        hotel1.setClassificacao(Classificacao.TRES_ESTRELAS);
        hotel1.setCidade("");
        hotel1.setEstado("");
        hotel1.setRua("");
        hotel1.setBairro("");
        hotel1.setComplemento("");
        hotel1.setNumero("");
        hotel1.setCnpj(597495945);
        hotelServico.cadastrar(hotel1);

        Quarto quarto1 = new Quarto();
        quarto1.setId(445455);
        quarto1.setTipoQuarto("");
        quarto1.setMetrosQuadrados(30);
        quarto1.setDiaria(230);
        quarto1.setOcupado(false);
        quarto1.setMaximoPessoas(2);
        quarto1.setRefeicao(false);
        quarto1.setTipoQuarto("Casal");
        quarto1.setNumeroCama(1);
        quarto1.setNumeroQuarto(23);
        quarto1.setHotelId(1111111);
        quartoServico.cadastrar(quarto1);

        Quarto quarto2 = new Quarto();
        quarto2.setId(445455);
        quarto2.setTipoQuarto("");
        quarto2.setMetrosQuadrados(30);
        quarto2.setDiaria(230);
        quarto2.setOcupado(false);
        quarto2.setMaximoPessoas(2);
        quarto2.setRefeicao(false);
        quarto2.setTipoQuarto("Casal");
        quarto2.setNumeroCama(1);
        quarto2.setNumeroQuarto(23);
        quarto2.setHotelId(1111111);
        quartoServico.cadastrar(quarto2);

        Hotel hotel2 = new Hotel();
        hotel1.setId(1111112);
        hotel1.setNome("Hotel");
        hotel1.setDescricao("");
        hotel1.setClassificacao(Classificacao.TRES_ESTRELAS);
        hotel1.setCidade("");
        hotel1.setEstado("");
        hotel1.setRua("");
        hotel1.setBairro("");
        hotel1.setComplemento("");
        hotel1.setNumero("");
        hotel1.setCnpj(597495945);
        hotelServico.cadastrar(hotel1);

        Quarto quarto3 = new Quarto();
        quarto3.setId(445455);
        quarto3.setTipoQuarto("");
        quarto3.setMetrosQuadrados(30);
        quarto3.setDiaria(230);
        quarto3.setOcupado(false);
        quarto3.setMaximoPessoas(2);
        quarto3.setRefeicao(false);
        quarto3.setTipoQuarto("Casal");
        quarto3.setNumeroCama(1);
        quarto3.setNumeroQuarto(23);
        quarto3.setHotelId(1111112);
        quartoServico.cadastrar(quarto3);

        Quarto quarto4 = new Quarto();
        quarto4.setId(445455);
        quarto4.setTipoQuarto("");
        quarto4.setMetrosQuadrados(30);
        quarto4.setDiaria(230);
        quarto4.setOcupado(false);
        quarto4.setMaximoPessoas(2);
        quarto4.setRefeicao(false);
        quarto4.setTipoQuarto("Casal");
        quarto4.setNumeroCama(1);
        quarto4.setNumeroQuarto(23);
        quarto4.setHotelId(1111112);
        quartoServico.cadastrar(quarto4);


        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        int entrada = -1;
        do{
            System.out.println("---- SEJA BEM-VINDO! ----");
            System.out.println("Para começar, digite o número corresponde a opção escolhida:");
            System.out.println("1 - Fazer uma reserva");
            System.out.println("2 - Me cadastrar");
            System.out.println("3 - Entrar");
            System.out.println("0 - Para sair");
            try{
                entrada = Integer.parseInt(scanner.next());
            } catch(Exception ex) {
                entrada = -1;
            }

            switch(entrada){
                case 0:
                    continuar = false;
                    break;

                case 1:
                    List<Hotel> hoteis = hotelServico.listar();
                    System.out.println("Escolha um hotel:");
                    for (int i = 0; i < hoteis.size(); i++){
                        System.out.println((i+1)+" - Para "+ hoteis.get(i).getNome());
                    }
                    Scanner scann = new Scanner(System.in);
                    //int numero = Integer.parseInt(scann.next());
                    long numero = Long.valueOf(Integer.parseInt(scann.next()));
                    numero--;
                    List<Quarto> quartos = quartoServico.listarPorHotel(hoteis.get(numero));

                    break;

                case 2:

                    break;

                case 3:

                    break;

                default:
                    System.out.println("Opção digitada é inválida, tente novamente!");
            }

        } while(continuar);

        System.out.println("Volte sempre!");
    }
}
