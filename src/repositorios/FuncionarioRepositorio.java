package repositorios;

import entidades.Funcionario;
import entidades.Hospede;
import enums.SexoEnum;
import interfaces.repositorio.IRepositorioGenerico;
import util.ConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepositorio implements IRepositorioGenerico<Funcionario> {

    private static FuncionarioRepositorio instance;
    public Connection conexao;

    private FuncionarioRepositorio() throws SQLException {
        this.conexao = ConnectionSingleton.getInstance().conexao;
    }

    public static FuncionarioRepositorio getInstance() throws SQLException {
        if(instance == null){
            instance = new FuncionarioRepositorio();
        }
        return instance;
    }

    @Override
    public boolean salvar(Funcionario funcionario) throws SQLException {
        try {
            String sql = ("INSERT INTO hospede (nome, dataNascimento, sexo, cpf, telefone, cargo, senha, status)" +
                    "values(?,?,?,?,?,?,?,?);");
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setInt(2, funcionario.getSexo().getIndex());
            ps.setDate(3, Date.valueOf(funcionario.getDataNascimento()));
            ps.setString(4, funcionario.getCpf());
            ps.setString(5, Integer.toString(funcionario.getTelefone()));
            ps.setString(6, funcionario.getCargo());
            ps.setString(7, funcionario.getSenha());
            ps.setString(8, funcionario.getStatus());

            int retorno = ps.executeUpdate();

            if (retorno == 0) {
                System.out.println("Não foi possível persistir 'funcionario'");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possível persistir 'funcionario'");
        }
        return true;
    }

    @Override
    public boolean alterar(int id, Funcionario funcionario) throws SQLException {
        try {
            String sql = ("UPDATE funcionario SET nome=?, data_nascimento=?, sexo=?, cpf=?, telefone=?," +
                    "cargo=?, senha=?, status=? WHERE id=?;");
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setDate(2, Date.valueOf(funcionario.getDataNascimento()));
            ps.setInt(3, funcionario.getSexo().getIndex());
            ps.setString(4, funcionario.getCpf());
            ps.setString(5, Integer.toString(funcionario.getTelefone()));
            ps.setString(6, funcionario.getCargo());
            ps.setString(7, funcionario.getSenha());
            ps.setString(8, funcionario.getSenha());
            ps.setInt(9, id);

            int retorno = ps.executeUpdate();

            if (retorno == 0) {
                System.out.println("Não foi possível atualizar 'funcionario'");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possível atualizar 'funcionario'");
        }
        return true;
    }


    @Override
    public boolean deletarPorId(long idFuncionario) throws SQLException {
        try {
            String sql = ("DELETE FROM funcionario WHERE id=?;");
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, (int) idFuncionario);

            boolean retorno = ps.execute(sql);

            if (!retorno) {
                System.out.println("Não foi possível deletar registro na tabela 'funcionario'");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possível deletar registro na tabela 'funcionario'");
        }
        return true;
    }

    @Override
    public List<Funcionario> listar() throws SQLException {
        try {
            String sql = ("SELECT * FROM funcionario;");
            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Funcionario> funcionarios = new ArrayList<>();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                funcionario.setSexo(SexoEnum.binaryToSexoEnum(rs.getInt("sexo")));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setTelefone(Integer.getInteger(rs.getString("telefone")));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setStatus(rs.getString("status"));

                funcionarios.add(funcionario);
            }

            return funcionarios;

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new SQLException("Não foi possíveal listar funcionario");
        }

    }
}
