import entidades.Hospede;
import entidades.Hotel;
import entidades.Quarto;
import entidades.Reserva;
import enums.Classificacao;
import enums.PagamentoEnum;
import repositorios.HospedeRepositorio;
import repositorios.PagamentoRepositorio;
import servicos.HospedeServico;
import servicos.HotelServico;
import servicos.QuartoServico;
import servicos.ReservaServico;

import java.net.StandardSocketOptions;
import java.sql.SQLOutput;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        HotelServico hotelServico = new HotelServico();
        QuartoServico quartoServico = new QuartoServico();

        Hotel hotel = new Hotel();
        hotel.setId(1);
        hotel.setNome("Hotel da Marina");
        hotel.setDescricao("");
        hotel.setClassificacao(Classificacao.TRES_ESTRELAS);
        hotel.setCidade("Recife");
        hotel.setEstado("Pernambuco");
        hotel.setRua("");
        hotel.setBairro("");
        hotel.setComplemento("");
        hotel.setNumero("");
        hotel.setCnpj(597495945);
        hotelServico.cadastrar(hotel);

        Quarto quarto1 = new Quarto();
        quarto1.setId(4);
        quarto1.setTipoQuarto("Single Room");
        quarto1.setTipoCama("Solteiro");
        quarto1.setMetrosQuadrados(30);
        quarto1.setDiaria(130);
        quarto1.setOcupado(false);
        quarto1.setMaximoPessoas(2);
        quarto1.setRefeicao(false);
        quarto1.setNumeroCama(1);
        quarto1.setNumeroQuarto(1);
        quarto1.setHotelId(1);
        quartoServico.cadastrar(quarto1);

        Quarto quarto2 = new Quarto();
        quarto2.setId(5);
        quarto2.setTipoQuarto("Suite");
        quarto2.setTipoCama("King Size");
        quarto2.setMetrosQuadrados(80);
        quarto2.setDiaria(500);
        quarto2.setOcupado(false);
        quarto2.setMaximoPessoas(2);
        quarto2.setRefeicao(false);
        quarto2.setNumeroCama(1);
        quarto2.setNumeroQuarto(2);
        quarto2.setHotelId(1);
        quartoServico.cadastrar(quarto2);

        Quarto quarto3 = new Quarto();
        quarto3.setId(4);
        quarto3.setTipoQuarto("Quarto casal");
        quarto3.setTipoCama("Casal");
        quarto3.setMetrosQuadrados(50);
        quarto3.setDiaria(230);
        quarto3.setOcupado(false);
        quarto3.setMaximoPessoas(2);
        quarto3.setRefeicao(false);
        quarto3.setNumeroCama(1);
        quarto3.setNumeroQuarto(3);
        quarto3.setHotelId(1);
        quartoServico.cadastrar(quarto3);

        Hospede hospede1 = new Hospede();
        hospede1.setNome("Maria Luiza da Silva Campos");
        hospede1.setEmail("marialuiza@gmail.com");
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
            System.out.println("0 - Sair/Fechar");
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
                    Scanner scann = new Scanner(System.in);
                    int numero = -1;
                    List<Quarto> quartos = quartoServico.listar();
                    System.out.println("Escolha um quarto:");
                    for (int i = 0; i < quartos.size(); i++){
                        System.out.println("\n"+(i+1)+" - Para: ");
                        System.out.println(" Tipo: " + quartos.get(i).getTipoQuarto());
                        System.out.println(" Tipo cama: " + quartos.get(i).getTipoCama());
                        System.out.println(" Tamanho do quarto: " + quartos.get(i).getMetrosQuadrados() + "m²");
                        System.out.printf(" Diária: R$%,3.2f\n", quartos.get(i).getDiaria());
                    }
                    numero = Integer.parseInt(scann.next());
                    numero = numero - 1;
                    reserva.setNumQuarto(quartos.get(numero).getNumeroQuarto());

                    System.out.println("Escolha a data de início:");
                    System.out.println("Digite o dia:");
                    int diaInicio = Integer.parseInt(scanner.next());
                    System.out.println("Digite o mês:");
                    int mesInicio = Integer.parseInt(scanner.next());
                    System.out.println("Digite o ano:");
                    int anoInicio = Integer.parseInt(scanner.next());
                    reserva.setDataInicio(LocalDate.of(anoInicio, mesInicio, diaInicio));

                    System.out.println("Escolha a data do fim:");
                    System.out.println("Digite o dia:");
                    int diaFim = Integer.parseInt(scanner.next());
                    System.out.println("Digite o mês:");
                    int mesFim = Integer.parseInt(scanner.next());
                    System.out.println("Digite o ano:");
                    int anoFim = Integer.parseInt(scanner.next());
                    reserva.setDataFim(LocalDate.of(anoFim, mesFim, diaFim));

                    System.out.println("Confira e confirme sua reserva:");
                    System.out.println("Quarto "+ quartoServico.listar(reserva.getNumQuarto()).getTipoQuarto());
                    System.out.printf("Diária: R$%,3.2f\n", quartoServico.listar(reserva.getNumQuarto()).getDiaria());
                    System.out.println("Data de entrada: " + reserva.getDataInicio());
                    System.out.println("Data de saída: " + reserva.getDataFim());
                    int numeroDias = (int) ChronoUnit.DAYS.between(reserva.getDataInicio(), reserva.getDataFim());
                    System.out.printf("Dias de estadia: %s\n", numeroDias);
                    float diaria = (float) quartoServico.listar(reserva.getNumQuarto()).getDiaria();
                    reserva.setValor(numeroDias * diaria);
                    System.out.printf("Valor: R$%,3.2f\n", reserva.getValor());
                    System.out.println("\nConfirmar reserva?\n1 - Sim\n0 - Não");
                    try{
                        numero = Integer.parseInt(scanner.next());
                    } catch (Exception ex){
                        System.out.println("Entrada inválida");
                        numero = 1;
                    }

                    if (numero == 1){

                        System.out.println("Escolha a forma de pagamento:");
                        System.out.println("1 - À vista");
                        System.out.println("2 - Débito");
                        System.out.println("3 - Crédito (sem juros)");
                        numero = Integer.parseInt(scanner.next());
                        switch (numero){
                            case 1:
                                System.out.printf("O pagamento de R$%,3.2f deve ser realizado em até 3 dias!\n",
                                        reserva.getValor());
                                break;
                            case 2:
                                System.out.println("Digite o número do cartão de débito:");
                                String numeroCartao = scann.next();
                                System.out.println("Digite o nome do titular:");
                                String nomeTitular = scann.next();
                                System.out.println("Digite a data de vencimento no formato dia/mes/ano:");
                                String dataVencimentoCartao = scann.next();
                                System.out.println("Pagamento realizado com sucesso!");
                                break;
                            case 3:
                                System.out.println("Digite o número do cartão de crédito:");
                                numeroCartao = scann.next();
                                System.out.println("Digite o nome do titular:");
                                nomeTitular = scann.next();
                                String aux = scann.nextLine();
                                System.out.println("Digite a data de vencimento no formato dia/mes/ano:");
                                dataVencimentoCartao = scann.next();
                                System.out.println("Digite o número de parcelas:");
                                int numeroParcelas = Integer.parseInt(scann.next());
                                System.out.printf("Você pagará %s parcelas de R$%,3.2f\n", numeroParcelas, reserva.getValor()/numeroParcelas);
                                System.out.println("Confirmar pagamento?\n1 - sim\n0 - Não ");
                                numero = scann.nextInt();
                                if(numero == 1)
                                    System.out.println("Pagamento realizado com sucesso!");
                                else
                                    System.out.println("Pagamento e reserva cancelados!");
                                break;
                        }
                        ReservaServico reservaServico = new ReservaServico();
                        reservaServico.cadastrar(reserva);
                        System.out.println("Reserva realizada com sucesso!");
                    } else if (numero == 0) {
                        System.out.println("Reserva cancelada!");
                    }

                    break;

                case 2:
                    scann = new Scanner(System.in);
                    Hospede hospede = new Hospede();
                    System.out.println("Digite seu nome completo:");
                    String nome = scann.nextLine();
                    hospede.setNome(nome);
                    System.out.println("Digite seu CPF:");
                    String cpf = scann.next();
                    hospede.setCpf(cpf);
                    System.out.println("Digite seu email:");
                    String email = scann.next();
                    hospede.setEmail(email);
                    System.out.println("Digite sua senha:");
                    String senha = scann.nextLine();
                    hospede.setSenha(senha);
                    hospedeServico.salvar(hospede);
                    System.out.println(" Cadastro realizado com sucesso! ");
                    break;

                case 3:
                    scann = new Scanner(System.in);
                    boolean conectado = false;
                    boolean encontrado = false;
                    int index = 0;
                    List<Hospede> hospedes = new ArrayList<>(HospedeRepositorio.getInstance().listar());
                    System.out.println("#   ENTRAR");
                    for(int i = 0; i < 3 && !encontrado; i++) {
                        System.out.println("Digite seu e-mail:");
                        email = scann.next();

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
                        senha = scann.next();
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
                        String[] nomeSplit = hospedes.get(index).getNome().split(" ");
                        System.out.println("Bem-vindo(a), "+nomeSplit[0]+" "+nomeSplit[nomeSplit.length - 1]+"!\n");
                    }
                    break;

                default:
                    System.out.println("Opção digitada é inválida, tente novamente!");
            }

        } while(continuar);

        System.out.println("Volte sempre!");
    }
}
