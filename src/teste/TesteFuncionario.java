package teste;

import servicos.FuncionarioServico;

import java.sql.SQLException;

public class TesteFuncionario {

    public static void main(String[] args) throws SQLException {

        FuncionarioServico funcionarioServico = new FuncionarioServico();

        // Inserção
        /*
        Funcionario funcionario1 = new Funcionario();

        funcionario1.setNome("Juan Gonzalez");
        funcionario1.setSexo(SexoEnum.MASCULINO);
        funcionario1.setDataNascimento(LocalDate.of(2000, 10, 3));
        funcionario1.setCpf("33009832789");
        funcionario1.setTelefone("990908181");
        funcionario1.setCargo("Gerente");
        funcionario1.setSenha("senha123");
        funcionario1.setStatus("Empregado");
        funcionario1.setSalario(1320);

        funcionarioServico.salvar(funcionario1);
        */

        // Busca
        /*
        List<Funcionario> funcionarios = funcionarioServico.listar();

        for (Funcionario funcionario : funcionarios){
            System.out.println("ID: "+funcionario.getId());
            System.out.println("NOME: "+funcionario.getNome());
            System.out.println("SEXO: "+funcionario.getSexo().getDescricao());
            System.out.println("DATA DE NASCIMENTO: "+funcionario.getDataNascimento());
            System.out.println("CPF: "+funcionario.getCpf());
            System.out.println("TELEFONE: "+funcionario.getTelefone());
            System.out.println("CARGO: "+funcionario.getCargo());
            System.out.println("STATUS: "+funcionario.getStatus());
            System.out.println("SALARIO: "+funcionario.getSalario()+"\n");
        }
        */

        // Atualização
        /*
        Funcionario funcionario2 = new Funcionario();

        funcionario2.setNome("Juan Gonzalez");
        funcionario2.setSexo(SexoEnum.MASCULINO);
        funcionario2.setDataNascimento(LocalDate.of(2000, 10, 3));
        funcionario2.setCpf("33009832789");
        funcionario2.setTelefone("990908181");
        funcionario2.setSenha("senha123");
        funcionario2.setCargo("Gerente");
        funcionario2.setStatus("Empregado");
        funcionario2.setSalario(2000);


        funcionarioServico.alterar(1, funcionario2);
        */

        // Exclusão
        /*
        funcionarioServico.deletarPorId(1);
        */

    }
}
