package teste;

import entidades.Hospede;
import enums.SexoEnum;
import servicos.HospedeServico;
import servicos.HotelServico;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class TesteHospede {
    public static void main(String[] args) throws SQLException {

        HospedeServico hospedeServico = new HospedeServico();

        // Inserção
        /*
        Hospede hospede1 = new Hospede();

        hospede1.setNome("Juan Gonzalez");
        hospede1.setSexo(SexoEnum.MASCULINO);
        hospede1.setDataNascimento(LocalDate.of(2000, 10, 3));
        hospede1.setCpf("33009832789");
        hospede1.setTelefone("990908181");
        hospede1.setEmail("juan_01@gmail.com");
        hospede1.setSenha("senha123");

        hospedeServico.cadastrar(hospede1);
        */

        // Busca
        /*
        List<Hospede> hospedes = hospedeServico.listar();

        for (Hospede hospede : hospedes){
            System.out.println("ID: "+hospede.getId());
            System.out.println("NOME: "+hospede.getNome());
            System.out.println("SEXO: "+hospede.getSexo().getDescricao());
            System.out.println("DATA DE NASCIMENTO: "+hospede.getDataNascimento());
            System.out.println("CPF: "+hospede.getCpf());
            System.out.println("TELEFONE: "+hospede.getTelefone());
            System.out.println("EMAIL: "+hospede.getEmail()+"\n");
        }
        */

        // Atualização
        /*
        Hospede hospede2 = new Hospede();

        hospede2.setNome("Julia Gonzalez");
        hospede2.setSexo(SexoEnum.FEMININO);
        hospede2.setDataNascimento(LocalDate.of(2000, 10, 3));
        hospede2.setCpf("33009832789");
        hospede2.setTelefone("990908181");
        hospede2.setEmail("julian_01@gmail.com");
        hospede2.setSenha("senha123");

        hospedeServico.alterar(1, hospede2);
        */

        // Exclusão
        /*
        hospedeServico.deletarPorId(1);
        */
    }
}
