package servicos;

import entidades.Funcionario;
import enums.SexoEnum;
import interfaces.servico.IBasicoServico;
import repositorios.FuncionarioRepositorio;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioServico implements IBasicoServico<Funcionario> {

    public void cadastrar(String nome, SexoEnum sexo, LocalDate dataNascimento, String cpf, long idFuncionario, String email, String senha, String telefone) {
        try{
            Funcionario novoFuncionario = new Funcionario();
            novoFuncionario.setId(idFuncionario);
            novoFuncionario.setNome(nome);
            novoFuncionario.setCpf(cpf);
            novoFuncionario.setDataNascimento(dataNascimento);
            novoFuncionario.setSexo(sexo);
            novoFuncionario.setTelefone(telefone);
            novoFuncionario.setSenha(senha);
            FuncionarioRepositorio.getInstance().salvar(novoFuncionario);
        }catch (Exception e){
            System.out.println("Error:"+e.getMessage());
        }

    }

    @Override
    public void salvar(Funcionario funcionario) throws SQLException {
        FuncionarioRepositorio.getInstance().salvar(funcionario);
    }

    @Override
    public void alterar(int id, Funcionario funcionario) throws SQLException {
        FuncionarioRepositorio.getInstance().alterar(id, funcionario);
    }

    @Override
    public List<Funcionario> listar() throws SQLException {
        List<Funcionario> funcionario = new ArrayList<>(FuncionarioRepositorio.getInstance().listar());
        return funcionario;
    }

    @Override
    public void deletarPorId(long idFuncionario) throws SQLException {
        FuncionarioRepositorio.getInstance().deletarPorId(idFuncionario);
    }

}
