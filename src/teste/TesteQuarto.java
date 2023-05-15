package teste;

import entidades.Quarto;
import enums.QuartoEnum;
import servicos.QuartoServico;

import java.sql.SQLException;
import java.util.List;

public class TesteQuarto {

    public static void main(String[] args) throws SQLException {

        QuartoServico quartoServico = new QuartoServico();

        // Inserção
        /*
        Quarto quarto1 = new Quarto();

        quarto1.setHotelId(2);
        quarto1.setOcupacaoMaxima(4);
        quarto1.setNumeroQuarto(4);
        quarto1.setTipoQuarto(QuartoEnum.QUADRUPLO);
        quarto1.setRefeicao(true);
        quarto1.setDiaria(229.90);
        quarto1.setOperante(true);
        quarto1.setDescricaoCama("Duas camas de casal");
        quarto1.setAndar(1);
        quarto1.setArea(25);

        quartoServico.cadastrar(quarto1);
        */

        // Busca
        /*
        List<Quarto> quartos = quartoServico.listar();

        for (Quarto quarto : quartos){
            System.out.println("ID: "+quarto.getId());
            System.out.println("HOTEL ID: "+quarto.getHotelId());
            System.out.println("NÚMERO: "+quarto.getNumeroQuarto());
            System.out.println("TIPO: "+quarto.getTipoQuarto());
            System.out.println("DESCRIÇÃO CAMA: "+quarto.getDescricaoCama());
            System.out.println("ÁREA: "+quarto.getArea());
            System.out.println("DIÁRIA: "+quarto.getDiaria());
            System.out.println("REFEIÇÃO: "+quarto.isRefeicao());
            System.out.println("OCUPAÇÃO MÁXIMA: "+quarto.getOcupacaoMaxima());
            System.out.println("ANDAR: "+quarto.getAndar());
            System.out.println("OPERANTE: "+quarto.isOperante()+"\n");
        }
        */

        // Busca (só operantes)
        /*
        List<Quarto> quartos = quartoServico.listarOperantes();

        if (quartos.size() == 0){
            System.out.println(">> Não há quartos operantes.");
        } else {
            for (Quarto quarto : quartos) {
                System.out.println("ID: " + quarto.getId());
                System.out.println("HOTEL ID: " + quarto.getHotelId());
                System.out.println("NÚMERO: " + quarto.getNumeroQuarto());
                System.out.println("TIPO: " + quarto.getTipoQuarto());
                System.out.println("DESCRIÇÃO CAMA: " + quarto.getDescricaoCama());
                System.out.println("ÁREA: " + quarto.getArea());
                System.out.println("DIÁRIA: " + quarto.getDiaria());
                System.out.println("REFEIÇÃO: " + quarto.isRefeicao());
                System.out.println("OCUPAÇÃO MÁXIMA: " + quarto.getOcupacaoMaxima());
                System.out.println("ANDAR: " + quarto.getAndar());
                System.out.println("OPERANTE: " + quarto.isOperante() + "\n");
            }
        }

        */

        // Atualização
        /*
        Quarto quarto2 = new Quarto();

        quarto2.setHotelId(1);
        quarto2.setOcupacaoMaxima(2);
        quarto2.setNumeroQuarto(4);
        quarto2.setTipoQuarto(QuartoEnum.DUPLO);
        quarto2.setRefeicao(true);
        quarto2.setDiaria(250);
        quarto2.setOperante(false);
        quarto2.setDescricaoCama("Uma cama de casal");
        quarto2.setAndar(1);
        quarto2.setArea(25);

        quartoServico.alterar(1, quarto2);
        */

        // Exclusão
        /*
        quartoServico.deletar(2);
        */
    }
}