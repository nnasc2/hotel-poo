import entidades.Hospede;
import entidades.Hotel;
import entidades.Quarto;
import entidades.Reserva;
import enums.Classificacao;
import repositorios.HospedeRepositorio;
import servicos.HospedeServico;
import servicos.HotelServico;
import servicos.QuartoServico;
import servicos.ReservaServico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        HotelServico hotelServico = new HotelServico();
        QuartoServico quartoServico = new QuartoServico();

        Hotel hotel1 = new Hotel();
        hotel1.setId(1111111);
        hotel1.setNome("Hotel da Marina");
        hotel1.setDescricao("");
        hotel1.setClassificacao(Classificacao.TRES_ESTRELAS);
        hotel1.setCidade("Recife");
        hotel1.setEstado("Pernambuco");
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
        hotel1.setNome("Hotel Campos Belos");
        hotel1.setDescricao("");
        hotel1.setClassificacao(Classificacao.TRES_ESTRELAS);
        hotel1.setCidade("Limoeiro");
        hotel1.setEstado("Pernambuco");
        hotel1.setRua("Rua João Augusto");
        hotel1.setBairro("Bairro da Tangerina");
        hotel1.setComplemento("");
        hotel1.setNumero("340");
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

        Hospede hospede1 = new Hospede();
        hospede1.setNome("Maria Luiza");
        hospede1.setEmail("m@g.com");
        hospede1.setSenha("12345");

        HospedeServico hospedeServico = new HospedeServico();
        hospedeServico.salvar(hospede1);


        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        int entrada = -1;
        System.out.println("---  Seja bem-vindo(a)!  ---");
        do{
            System.out.println("<<   INÍCIO   >>");
            System.out.println("Digite o número corresponde a opção escolhida:");
            System.out.println("1 - Fazer uma reserva");
            System.out.println("2 - Cadastrar");
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
                    Reserva reserva = new Reserva();

                    List<String> estados = hotelServico.listarTodosEstados();
                    System.out.println("Escolha o estado para o qual deseja ir:");
                    for (int i = 0; i < estados.size(); i++){
                        System.out.println((i+1) +" - "+ estados.get(i));
                    }
                    int numero = Integer.parseInt(scanner.next());
                    List<String> cidades = hotelServico.listarCidadesPorEstado(estados.get(numero-1));
                    System.out.println("Escolha a cidade para a qual deseja ir:");
                    for (int i = 0; i < cidades.size(); i++){
                        System.out.println((i+1) +" - "+ cidades.get(i));
                    }
                    numero = Integer.parseInt(scanner.next());
                    System.out.println("Escolha um hotel:");
                    List<Hotel> hoteis = hotelServico.listar();
                    for (int i = 0; i < hoteis.size(); i++){
                        System.out.println((i+1)+" - Para "+ hoteis.get(i).getNome());
                        System.out.println("Classificação: " + hoteis.get(i).getClassificacao().getDescricao());
                        System.out.println("");
                    }
                    Scanner scann = new Scanner(System.in);
                    numero = Integer.parseInt(scann.next());
                    numero = numero - 1;
                    reserva.setIdHotel(hoteis.get(numero).getId());
                    List<Quarto> quartos = quartoServico.listarPorHotel(hoteis.get(numero).getId());
                    System.out.println("Escolha um quarto:");
                    for (int i = 0; i < quartos.size(); i++){
                        System.out.println((i+1)+" - Para: ");
                        System.out.println(quartos.get(i).getTipoQuarto());
                        System.out.println(quartos.get(i).getTipoCama());
                        System.out.println(quartos.get(i).getMetrosQuadrados());
                    }
                    numero = Integer.parseInt(scann.next());
                    numero = numero - 1;
                    reserva.setNumQuarto(quartos.get(numero).getNumeroQuarto());

                    System.out.println("Confirmar reserva?\n1 - Sim\n0 - Não");
                    try{
                        numero = Integer.parseInt(scanner.next());
                    } catch (Exception ex){
                        System.out.println("Entrada inválida");
                        numero = 1;
                    }

                    if (numero == 1){
                        ReservaServico reservaServico = new ReservaServico();
                        reservaServico.cadastrar(reserva);
                        System.out.println("Reserva realizada com sucesso!");
                    } else if (numero == 0) {
                        System.out.println("Reserva cancelada!");
                    }

                    break;

                case 2:
                    Hospede hospede = new Hospede();
                    System.out.println("Digite seu nome:");
                    hospede.setNome(scanner.next());
                    System.out.println("Digite seu CPF:");
                    hospede.setNome(scanner.next());
                    System.out.println("Digite seu email:");
                    hospede.setNome(scanner.next());
                    System.out.println("Digite sua senha:");
                    hospede.setNome(scanner.next());
                    hospedeServico.salvar(hospede);
                    System.out.println(" Cadastro realizado com sucesso! ");
                    break;

                case 3:
                    boolean conectado = false;
                    boolean encontrado = false;
                    int index = 0;
                    List<Hospede> hospedes = new ArrayList<>(HospedeRepositorio.getInstance().listar());
                    for(int i = 0; i < 3 && !encontrado; i++) {
                        System.out.println("Digite seu e-mail:");
                        String email = scanner.next();

                        for (int j = 0; j < hospedes.size(); j++) {
                            if (hospedes.get(j).getEmail().equals(email)) {
                                encontrado = true;
                                index = j;
                                break;
                            }
                        }

                        if (!encontrado && i < 2){
                            System.out.println("Seu email não foi encontrado! Tente novamente ou cadastre-se.\n");
                        } else if (!encontrado && i < 3){
                            System.out.println("Número de tentativas esgotado! Tente novamente ou cadastre-se.\n");
                        }
                    }

                    for (int i = 0; i < 3 && encontrado; i++) {
                        System.out.println("Digite sua senha:");
                        String senha = scanner.next();
                        if(hospedes.get(index).getSenha().equals(senha)){
                            conectado = true;
                            break;
                        }

                        if (!conectado && i < 2){
                            System.out.println("Senha incorreta! Tente novamente ou cadastre-se.\n");
                        } else if (!conectado && i < 3){
                            System.out.println("Número de tentativas esgotado! Tente novamente ou cadastre-se.\n");
                        }
                    }

                    if (encontrado && conectado){
                        System.out.println("Bem-vindo(a), "+hospedes.get(index).getNome()+"!\n");
                    }
                    break;

                default:
                    System.out.println("Opção digitada é inválida, tente novamente!");
            }

        } while(continuar);

        System.out.println("Volte sempre!");
    }
}
