package gui;

import entidades.*;
import enums.ClassificacaoEnum;
import enums.QuartoEnum;
import repositorios.HospedeRepositorio;
import servicos.HospedeServico;
import servicos.HotelServico;
import servicos.QuartoServico;
import servicos.ReservaServico;
import util.ValidadorCPF;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {

        HotelServico hotelServico = new HotelServico();
        QuartoServico quartoServico = new QuartoServico();

        /*
        Hotel hotel = new Hotel();
        hotel.setNome("Roland Hotel");
        hotel.setDescricao("");
        hotel.setClassificacao(ClassificacaoEnum.QUATRO_ESTRELAS);
        hotel.setEstado("Pernambuco");
        hotel.setCidade("Ipojuca");
        hotel.setRua("João Joaquim");
        hotel.setBairro("Porto de Galinhas");
        hotel.setComplemento("");
        hotel.setNumero(290);
        hotel.setCnpj("23.455.121/0001-66");
        hotelServico.cadastrar(hotel);

        Quarto quarto1 = new Quarto();
        quarto1.setTipoQuarto(QuartoEnum.INDIVIDUAL);
        quarto1.setDescricaoCama("Uma cama de solteiro");
        quarto1.setArea(20);
        quarto1.setDiaria(130);
        quarto1.setOperante(true);
        quarto1.setOcupacaoMaxima(1);
        quarto1.setRefeicao(false);
        quarto1.setNumeroQuarto(1);
        quarto1.setHotelId(hotel.getId());
        quartoServico.cadastrar(quarto1);

        Quarto quarto2 = new Quarto();
        quarto2.setTipoQuarto(QuartoEnum.DUPLO);
        quarto2.setDescricaoCama("Uma cama de casal");
        quarto2.setArea(30);
        quarto2.setDiaria(230);
        quarto2.setOperante(true);
        quarto2.setOcupacaoMaxima(2);
        quarto2.setRefeicao(false);
        quarto2.setNumeroQuarto(2);
        quarto2.setHotelId(hotel.getId());
        quartoServico.cadastrar(quarto2);

        Quarto quarto3 = new Quarto();
        quarto3.setTipoQuarto(QuartoEnum.TRIPLO);
        quarto3.setDescricaoCama("Uma cama de casal e uma cama de solteiro");
        quarto3.setArea(40);
        quarto3.setDiaria(330);
        quarto3.setOperante(true);
        quarto3.setOcupacaoMaxima(3);
        quarto3.setRefeicao(false);
        quarto3.setNumeroQuarto(3);
        quarto3.setHotelId(1);
        quartoServico.cadastrar(quarto3);

        Quarto quarto4 = new Quarto();
        quarto4.setTipoQuarto(QuartoEnum.QUADRUPLO);
        quarto4.setDescricaoCama("Uma cama de casal e duas de solteiro");
        quarto4.setArea(60);
        quarto4.setDiaria(500);
        quarto4.setOperante(true);
        quarto4.setOcupacaoMaxima(4);
        quarto4.setRefeicao(false);
        quarto4.setNumeroQuarto(4);
        quarto4.setHotelId(1);
        quartoServico.cadastrar(quarto4);

        Hospede hospedeTeste = new Hospede();

        hospedeTeste.setNome("Maria Luiza da Silva Campos");
        hospedeTeste.setEmail("marialuiza@gmail.com");
        hospedeTeste.setSenha("12345");
        */
        HospedeServico hospedeServico = new HospedeServico();
        /*
        hospedeServico.salvar(hospedeTeste);
         */

        Scanner scanner = new Scanner(System.in);
        boolean voltar = false;
        boolean continuar = true;
        int entrada = -1;
        System.out.printf(">> Seja bem-vindo(a) ao %s!\n\n", hotelServico.listar().get(0).getNome());
        do{
            System.out.println("--   Menu Inicial   --");
            System.out.println("1 - Fazer uma reserva");
            System.out.println("2 - Cadastrar-se");
            System.out.println("3 - Entrar");
            System.out.println("0 - Sair/Fechar\n");
            System.out.println("Digite o número corresponde a opção escolhida:");
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
                    System.out.println("Escolha um destes quartos:");
                    for (int i = 0; i < quartos.size(); i++){
                        System.out.println("\n"+(i+1)+" - "+ quartos.get(i).getTipoQuarto().getDescricao());
                        System.out.println("    Cama(s): " + quartos.get(i).getDescricaoCama());
                        System.out.println("    Capacidade para: "+quartos.get(i).getOcupacaoMaxima()+" pessoa(s)");
                        System.out.println("    Tamanho do quarto: " + quartos.get(i).getArea() + "m²");
                        System.out.printf("    Diária: R$%,3.2f\n", quartos.get(i).getDiaria());
                    }
                    do {
                        System.out.println("\nDigite o número correspondente ao quarto escolhido:");
                        try{
                            numero = Integer.parseInt(scanner.next());
                            if(numero < 1 || numero > quartos.size()){
                                System.out.println(">> Opção inválida! Tente novamente");
                                voltar = true;
                            } else {
                                voltar = false;
                            }
                        } catch (Exception ex){
                            System.out.println(">> Entrada inválida! Tente novamente");
                            voltar = true;
                        }
                    } while (voltar);
                    numero = numero - 1;
                    reserva.setNumQuarto(quartos.get(numero).getNumeroQuarto());

                    do {
                        try{
                            System.out.println("Escolha a data de entrada (check-in):");
                            System.out.println("Digite o dia:");
                            int diaInicio = Integer.parseInt(scanner.next());
                            System.out.println("Digite o mês:");
                            int mesInicio = Integer.parseInt(scanner.next());
                            System.out.println("Digite o ano:");
                            int anoInicio = Integer.parseInt(scanner.next());
                            reserva.setDataInicio(LocalDate.of(anoInicio, mesInicio, diaInicio));
                            voltar = false;
                        } catch(Exception e){
                            voltar = true;
                            System.out.println(">> Data inválida, tente novamente.");
                        }
                    } while(voltar);

                    do {
                        try {
                            System.out.println("Escolha a data de saída (check-out):");
                            System.out.println("Digite o dia:");
                            int diaFim = Integer.parseInt(scanner.next());
                            System.out.println("Digite o mês:");
                            int mesFim = Integer.parseInt(scanner.next());
                            System.out.println("Digite o ano:");
                            int anoFim = Integer.parseInt(scanner.next());
                            reserva.setDataFim(LocalDate.of(anoFim, mesFim, diaFim));
                            voltar = false;
                        } catch (Exception e) {
                            System.out.println(">> Data inválida, tente novamente.");
                            voltar = true;
                        }
                    } while(voltar);

                    System.out.println("Confira e confirme sua reserva:\n");
                    System.out.println(quartoServico.listar(reserva.getNumQuarto()).getTipoQuarto());
                    System.out.printf("Diária: R$%,3.2f\n", quartoServico.listar(reserva.getNumQuarto()).getDiaria());
                    System.out.println("Data de entrada (check-in): " + reserva.getDataInicio());
                    System.out.println("Data de saída (check-out): " + reserva.getDataFim());
                    int numeroDias = (int) ChronoUnit.DAYS.between(reserva.getDataInicio(), reserva.getDataFim());
                    System.out.printf("Dias de estadia: %s\n", numeroDias);
                    float diaria = (float) quartoServico.listar(reserva.getNumQuarto()).getDiaria();
                    reserva.setValor(numeroDias * diaria);
                    System.out.printf("Valor: R$%,3.2f\n", reserva.getValor());
                    do {
                        System.out.println("\nConfirmar reserva?\n1 - Sim\n0 - Não");
                        try{
                            numero = Integer.parseInt(scanner.next());
                            if(numero < 0 || numero > 1){
                                System.out.println(">> Opção inválida! Tente novamente\n");
                                voltar = true;
                            } else {
                                ReservaServico reservaServico = new ReservaServico();
                                reservaServico.cadastrar(reserva);
                                voltar = false;
                            }
                        } catch (Exception ex){
                            System.out.println(">> Entrada inválida! Tente novamente\n");
                            voltar = true;
                        }
                    } while (voltar);

                    if (numero == 1){

                        try {
                            System.out.println("Escolha a forma de pagamento:");
                            System.out.println("1 - À vista");
                            System.out.println("2 - Débito");
                            System.out.println("3 - Crédito (sem juros)");
                            numero = Integer.parseInt(scanner.next());
                            voltar = false;
                        } catch (Exception e){
                            System.out.println(">> Entrada inválida, tente novamente.");
                            voltar = true;
                        }

                        switch (numero){
                            case 1:
                                System.out.printf("O pagamento de R$%,3.2f deve ser realizado em até 7 dias!\n",
                                        reserva.getValor());
                                break;
                            case 2:
                                System.out.println("Digite o número do cartão de débito:");
                                String numeroCartao = scann.next();
                                System.out.println("Digite o nome do titular:");
                                String nomeTitular = scann.next();
                                System.out.println("Digite a data de vencimento no formato dia/mes/ano:");
                                String dataVencimentoCartao = scann.next();
                                System.out.println(">> Pagamento realizado com sucesso!");
                                break;
                            case 3:
                                System.out.println("Digite o número do cartão de crédito:");
                                numeroCartao = scann.next();
                                System.out.println("Digite o nome do titular:");
                                nomeTitular = scann.next();
                                String aux = scann.nextLine();
                                System.out.println("Digite a data de vencimento no formato dia/mes/ano:");
                                dataVencimentoCartao = scann.next();
                                int numeroParcelas = 0;
                                do{
                                    System.out.println("Digite o número de parcelas (máximo de 6x):");
                                    try{
                                        numeroParcelas = Integer.parseInt(scann.next());
                                        if (numeroParcelas >= 1 && numeroParcelas <= 6){
                                            voltar = false;
                                        } else {
                                            String mensagem = ">> Número inválido de parcelas! Tente novamente";
                                            if(numeroParcelas > 6){
                                                mensagem = ">> Número máximo de parcelas ultrapassado! Tente novamente.";
                                            }
                                            System.out.println(mensagem);
                                            voltar = true;
                                        }
                                    } catch (Exception e) {
                                        System.out.println(">> Opção inválida! Tente novamente.");
                                        voltar = true;
                                    }
                                } while (voltar);

                                System.out.printf("Você pagará %s parcelas de R$%,3.2f\n", numeroParcelas, reserva.getValor()/numeroParcelas);
                                System.out.println("Confirmar pagamento?\n1 - sim\n0 - Não ");
                                numero = scann.nextInt();
                                if(numero == 1)
                                    System.out.println(">> Pagamento realizado com sucesso!");
                                else
                                    System.out.println(">> Pagamento e reserva cancelados!");
                                break;
                        }
                        ReservaServico reservaServico = new ReservaServico();
                        reservaServico.cadastrar(reserva);
                        System.out.println(">> Reserva realizada com sucesso!\n");
                    } else if (numero == 0) {
                        System.out.println(">> Reserva cancelada!\n");
                    }

                    break;

                case 2:
                    scann = new Scanner(System.in);
                    Hospede hospede = new Hospede();
                    System.out.println("Digite seu nome completo:");
                    String nome = scann.nextLine();
                    hospede.setNome(nome);

                    do {
                        try {
                            System.out.println("Digite seu CPF(apenas números):");
                            String cpf = scann.next();
                            if (ValidadorCPF.eValido(cpf)){
                                hospede.setCpf(cpf);
                                voltar = false;
                            } else {
                                System.out.println("CPF inválido! Tente novamente.");
                                voltar = true;
                            }
                        } catch (Exception e) {
                            System.out.println("CPF inválido! Tente novamente.");
                            voltar = true;
                        }
                    } while(voltar);

                    System.out.println("Digite sua data de nascimento no formato dia/mes/ano:");
                    String dataNascimento = scann.next();
                    System.out.println("Digite seu email:");
                    String email = scann.next();
                    hospede.setEmail(email);
                    System.out.println("Digite sua senha:");
                    String senha = scann.nextLine();
                    hospede.setSenha(senha);
                    hospedeServico.salvar(hospede);
                    System.out.println(">> Cadastro realizado com sucesso! ");
                    break;

                case 3:
                    scann = new Scanner(System.in);
                    boolean conectado = false;
                    boolean encontrado = false;
                    int index = 0;
                    List<Hospede> hospedes = new ArrayList<>(HospedeRepositorio.getInstance().listar());
                    System.out.println("--   Entrada   --");
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
                            System.out.println(">> Seu email não foi encontrado! Tente novamente.\n");
                        } else if (!encontrado && i < 3){
                            System.out.println(">> Número de tentativas esgotado! Tente novamente mais tarde ou cadastre-se.\n");
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
                            System.out.println(">> Senha incorreta! Tente novamente.\n");
                        } else if (!conectado && i < 3){
                            System.out.println(">> Número de tentativas esgotado! Tente novamente mais tarde.\n");
                        }
                    }

                    if (encontrado && conectado){
                        String[] nomeSplit = hospedes.get(index).getNome().split(" ");
                        System.out.println(">> Bem-vindo(a), "+nomeSplit[0]+" "+nomeSplit[nomeSplit.length - 1]+"!\n");
                    }
                    break;

                default:
                    System.out.println(">> Opção digitada é inválida, tente novamente!");
            }

        } while(continuar);

        System.out.println(">> Volte sempre!");
    }
}
