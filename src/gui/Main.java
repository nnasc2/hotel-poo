package gui;

import entidades.*;
import enums.SexoEnum;
import repositorios.HospedeRepositorio;
import servicos.*;
import util.ValidadorCPF;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {

        HotelServico hotelServico = new HotelServico();
        QuartoServico quartoServico = new QuartoServico();
        ReservaServico reservaServico = new ReservaServico();
        HospedeServico hospedeServico = new HospedeServico();
        FuncionarioServico funcionarioServico = new FuncionarioServico();

        Scanner scanner = new Scanner(System.in);
        boolean conectado = false;
        int hospedeLogadoId = 0;
        boolean voltar = false;
        boolean continuar = true;
        int entrada = -1;
        System.out.printf(">> Seja bem-vindo(a) ao %s!\n\n", hotelServico.listar().get(0).getNome());
        do{
            System.out.println("--   Menu Inicial   --");
            System.out.println("1 - Fazer uma reserva");
                if (!conectado){
                    System.out.println("2 - Cadastrar-se");
                    System.out.println("3 - Entrar");
                }
                if (conectado){
                    System.out.println("2 - Minhas reservas");
                    System.out.println("3 - Excluir conta");

                }
            System.out.println("0 - Sair/Fechar\n");
            System.out.println("Digite o número corresponde a opção escolhida:");
            try{
                entrada = Integer.parseInt(scanner.next());
                if (!conectado){
                    switch (entrada){
                        case 5:
                            entrada = -1;
                            break;
                        case 6:
                            entrada = -1;
                            break;
                    }
                }
                if(conectado){
                    if(entrada == 4){
                        entrada = -1;
                    }
                    switch (entrada){
                        case 2:
                            entrada = 5;
                            break;
                        case 3:
                            entrada = 6;
                            break;
                        case 5:
                            entrada = -1;
                            break;
                        case 6:
                            entrada = -1;
                            break;
                    }

                }
            } catch(Exception ex) {
                entrada = -1;
            }

            switch(entrada){
                case 0:
                    continuar = false;
                    break;

                case 1:
                    Scanner scann = new Scanner(System.in);
                    Hospede hospede = new Hospede();
                    int contador = 0;

                    do {
                        try {
                            System.out.println("Digite seu CPF(apenas números):");
                            String cpf = scann.next();
                            if (ValidadorCPF.eValido(cpf)){
                                List<Hospede> hospedes = hospedeServico.listar();
                                for (Hospede hosp : hospedes) {
                                    if (hosp.getCpf().equals(cpf)) {
                                        System.out.println(">> Bem-vindo(a) novamente!");
                                        hospede.setId(hosp.getId());
                                        hospede.setNome(hosp.getNome());
                                        hospede.setCpf(hosp.getCpf());
                                        hospede.setDataNascimento(hosp.getDataNascimento());
                                        hospede.setTelefone(hosp.getTelefone());
                                        hospede.setSexo(hosp.getSexo());
                                        hospede.setEmail(hosp.getEmail());
                                        hospede.setSenha(hosp.getSenha());
                                        voltar = false;
                                    } else {
                                        hospede.setCpf(cpf);
                                        voltar = false;
                                    }
                                }
                            } else {
                                if (contador == 3){
                                    System.out.println(">> Número de tentativas engotado!");
                                    break;
                                }
                                System.out.println(">> CPF inválido! Tente novamente.");
                                voltar = true;
                                contador++;
                            }
                        } catch (Exception e) {
                            System.out.println(">> CPF inválido! Tente novamente.");
                            voltar = true;
                        }
                    } while(voltar);

                    if (hospede.getId() != 0){
                        System.out.println(">> Vamos iniciar um rápido cadastro antes que possa reservar um quarto.");
                        do {
                            try {
                                System.out.println("Digite o seu nome completo:");
                                String nome = scann.nextLine();
                                if (nome.equals("") || nome.equals(" ") || nome.contains("1")  || nome.contains("2")
                                        || nome.contains("3") || nome.contains("4") || nome.contains("5")
                                        || nome.contains("6") || nome.contains("7") || nome.contains("8")
                                        || nome.contains("9") || nome.contains("0")){
                                    System.out.println("Nome inválido! Tente novamente.");
                                    voltar = true;
                                } else {
                                    hospede.setNome(nome);
                                    voltar = false;
                                }
                            } catch (Exception e) {
                                System.out.println("Nome inválido! Tente novamente.");
                                voltar = true;
                            }
                        } while(voltar);

                        do {
                            try{
                                System.out.println("Informe a sua data de nascimento:");
                                System.out.println("Digite o dia do mês:");
                                int dia = Integer.parseInt(scanner.next());
                                System.out.println("Digite o número mês:");
                                int mes = Integer.parseInt(scanner.next());
                                System.out.println("Digite o ano:");
                                int ano = Integer.parseInt(scanner.next());
                                hospede.setDataNascimento(LocalDate.of(ano, mes, dia));
                                voltar = false;
                            } catch(Exception e){
                                voltar = true;
                                System.out.println(">> Data inválida, tente novamente.");
                            }
                        } while(voltar);

                        do {
                            try {
                                System.out.println("Escolha entre as opções abaixo:");
                                for (SexoEnum sexo : SexoEnum.values()){
                                    System.out.println(sexo.getIndex()+" - Sou do sexo "+sexo.getDescricao());
                                }
                                int sexo = scann.nextInt();
                                if (sexo < 1 || sexo > SexoEnum.values().length){
                                    System.out.println(">> Opção inválida! Tente novamente.");
                                    voltar = true;
                                } else {
                                    hospede.setSexo(SexoEnum.intToSexoEnum(sexo));
                                    voltar = false;
                                }
                            } catch (Exception e){
                                System.out.println(">> Opção inválida! Tente novamente.");
                                voltar = true;
                            }
                        } while(voltar);

                        do {
                            try {
                                System.out.println("Digite o seu telefone:");
                                String telefone2 = scann.next();
                                hospede.setTelefone(telefone2);
                            } catch (Exception e) {
                                System.out.println("Entrada inválida! Tente novamente.");
                                voltar = true;
                            }
                        } while(voltar);

                        do {
                            try {
                                System.out.println("Digite a email:");
                                String email2 = scann.next();
                                hospede.setEmail(email2);
                            } catch (Exception e) {
                                System.out.println("Entrada inválida! Tente novamente.");
                                voltar = true;
                            }
                        } while(voltar);

                        do {
                            try {
                                System.out.println("Digite a senha:");
                                String senha2 = scann.next();
                                hospede.setSenha(senha2);
                            } catch (Exception e) {
                                System.out.println("Entrada inválida! Tente novamente.");
                                voltar = true;
                            }
                        } while(voltar);

                        hospedeServico.salvar(hospede);
                        System.out.println(">> Cadastro realizado com sucesso! ");
                    }

                    Reserva reserva = new Reserva();
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
                                reserva.setNumQuarto(quartos.get(numero -1).getNumeroQuarto());
                                reserva.setIdHotel(quartos.get(numero -1).getHotelId());
                                reserva.setIdHospede(hospede.getId());
                                voltar = false;
                            }
                        } catch (Exception ex){
                            System.out.println(">> Entrada inválida! Tente novamente");
                            voltar = true;
                        }
                    } while (voltar);

                    do {
                        try{
                            System.out.println("Escolha a data de entrada (check-in):");
                            System.out.println("Digite o dia do mês:");
                            int diaInicio = Integer.parseInt(scanner.next());
                            System.out.println("Digite o número mês:");
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
                                System.out.println("Digite o número do seu cartão de débito:");
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
                        reservaServico.cadastrar(reserva);
                        hospede = null;
                        System.out.println(">> Reserva realizada com sucesso!\n");
                    } else if (numero == 0) {
                        System.out.println(">> Reserva cancelada!\n");
                    }

                    break;

                case 2:
                    scann = new Scanner(System.in);
                    hospede = new Hospede();

                    do {
                        try {
                            System.out.println("Digite o nome completo:");
                            String nome = scann.nextLine();
                            if (nome.equals("") || nome.equals(" ") || nome.contains("1")  || nome.contains("2")
                                    || nome.contains("3") || nome.contains("4") || nome.contains("5")
                                    || nome.contains("6") || nome.contains("7") || nome.contains("8")
                                    || nome.contains("9") || nome.contains("0")){
                                System.out.println("Nome inválido! Tente novamente.");
                                voltar = true;
                            } else {
                                hospede.setNome(nome);
                                voltar = false;
                            }
                        } catch (Exception e) {
                            System.out.println("Nome inválido! Tente novamente.");
                            voltar = true;
                        }
                    } while(voltar);

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

                    do {
                        try {
                            System.out.println("Escolha entre as opções abaixo:");
                            for (SexoEnum sexo : SexoEnum.values()){
                                System.out.println(sexo.getIndex()+" - Sou do sexo "+sexo.getDescricao());
                            }
                            int sexo = scann.nextInt();
                            if (sexo < 1 || sexo > SexoEnum.values().length){
                                System.out.println(">> Opção inválida! Tente novamente.");
                                voltar = true;
                            } else {
                                hospede.setSexo(SexoEnum.intToSexoEnum(sexo));
                                voltar = false;
                            }
                        } catch (Exception e){
                            System.out.println(">> Opção inválida! Tente novamente.");
                            voltar = true;
                        }
                    } while(voltar);

                    System.out.println("Digite seu telefone:");
                    String telefone = scann.next();
                    hospede.setTelefone(telefone);

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
                    conectado = false;
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
                            hospedes.get(index).getId();
                            conectado = true;

                        }

                        if (!conectado && i < 2){
                            System.out.println(">> Senha incorreta! Tente novamente.\n");
                        }
                    }

                    if (encontrado && conectado){
                        String[] nomeSplit = hospedes.get(index).getNome().split(" ");
                        System.out.println(">> Bem-vindo(a), "+nomeSplit[0]+" "+nomeSplit[nomeSplit.length - 1]+"!\n");
                    }
                case 4:

                    break;

                case 5:
                    System.out.println("-- Minhas reservas --");
                    List<Reserva> tReservas = reservaServico.listar();
                    List<Reserva> mReservas = new ArrayList<>();
                    for (Reserva reserv : tReservas) {
                        if (reserv.getIdHospede() == hospedeLogadoId){
                            mReservas.add(reserv);
                        }
                    }

                    if (mReservas.size() == 0){
                        System.out.println(">> Você não possui reservas!");
                    } else {
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        for (Reserva reservaw : mReservas){
                            Hotel hot = hotelServico.listarHotelPorId(reservaw.getIdHotel());
                            System.out.println("CÓDIGO: "+reservaw.getId());
                            System.out.println("HOTEL: "+hot.getNome());
                            System.out.println("NÚMERO DO QUARTO: "+reservaw.getNumQuarto());
                            System.out.println("DATA INÍCIO: "+reservaw.getDataInicio().format(formato));
                            System.out.println("DATA FIM: "+reservaw.getDataFim().format(formato));
                            System.out.printf("VALOR: R$%,3.2f\n\n", reservaw.getValor());
                        }

                        System.out.println("[1] Cancelar reserva      [2] Fazer checkin      [3] Fazer checkout      [0] Fechar");
                        scann = new Scanner(System.in);
                        int entr = Integer.parseInt(scann.next());
                        if(entr == 1){
                            System.out.println("-- Cancelar reserva --\nDigite o código da reserva: ");
                            entr = Integer.parseInt(scann.next());
                            reservaServico.deletar(entr);
                            System.out.println(">> Reserva cancelada!");
                        } else if (entr == 2){
                            System.out.println("-- Fazer checkin --\nDigite o código da reserva: ");
                            entr = Integer.parseInt(scann.next());
                            Reserva reser = new Reserva();
                            for (Reserva reserv : reservaServico.listar()){
                                if (reserv.getId() == entr){
                                    reser = reserv;
                                }
                            }
                            reser.setDataCheckin(LocalDate.now());
                            reservaServico.alterar(entr, reser);
                            System.out.println(">> Checkin realizado!");
                        } else if(entr == 3){
                            System.out.println("-- Fazer checkout --\nDigite o código da reserva: ");
                            entr = Integer.parseInt(scann.next());
                            Reserva reser = new Reserva();
                            for (Reserva reserv : reservaServico.listar()){
                                if (reserv.getId() == entr){
                                    reser = reserv;
                                }
                            }
                            reser.setDataCheckout(LocalDate.now());
                            reservaServico.alterar(entr, reser);
                            System.out.println(">> Checkout realizado!");
                        } else if(entr == 0){
                            break;
                        }
                    }

                    break;
                case 6:
                    System.out.println("-- Excluir conta --");
                    do {
                        System.out.println("Tem certeza que deseja excluir sua conta?\n 1 - Sim\n 0 - Não");
                        scann = new Scanner(System.in);
                        int ent = 0;
                        try {
                            ent = Integer.parseInt(scann.next());
                            if (ent < 0 || ent > 1){
                                System.out.println(">> Entrada inválida! Tente novamente.");
                                voltar = true;
                            }
                        } catch (Exception e) {
                            System.out.println(">> Entrada inválida! Tente novamente.");
                            voltar = true;
                        }
                        if (ent == 1){
                            hospedeServico.deletarPorId(hospedeLogadoId);
                            System.out.println(">> Conta excluida");
                            hospedeLogadoId = 0;
                        }
                        if (ent == 0){
                            break;
                        }
                    } while(voltar);
                    break;
                default:
                    System.out.println(">> Opção digitada é inválida, tente novamente!");
            }

        } while(continuar);

        System.out.println(">> Fim");
    }
}
