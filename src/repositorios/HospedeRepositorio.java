package repositorios;

import entidades.Hospede;
import entidades.Reserva;
import enums.SexoEnum;
import interfaces.repositorio.IRepositorioGenerico;
import util.ConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospedeRepositorio implements IRepositorioGenerico<Hospede> {
    private static HospedeRepositorio instance;
    public Connection conexao;

    private HospedeRepositorio() throws SQLException {
        this.conexao = ConnectionSingleton.getInstance().conexao;
    }

    public static IRepositorioGenerico<Hospede> getInstance() throws SQLException {
        if (instance == null) {
            instance = new HospedeRepositorio();
        }
        return instance;

    }


    @Override
    public boolean salvar(Hospede hospede) throws SQLException {
        try {
            String sql = ("INSERT INTO hospede (nome, sexo, dataNascimento, cpf, telefone, email, senha) values(?,?,?,?,?,?,?);");
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, hospede.getNome());
            ps.setInt(2, hospede.getSexo().getIndex());
            ps.setDate(3, Date.valueOf(hospede.getDataNascimento()));
            ps.setString(4, hospede.getCpf());
            ps.setString(5, Integer.toString(hospede.getTelefone()));
            ps.setString(6, hospede.getEmail());
            ps.setString(7, hospede.getSenha());

            int retorno = ps.executeUpdate();

            if (retorno == 0) {
                System.out.println("Não foi possível persistir 'hospede'");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possível persistir 'hospede'");
        }
        return true;
    }

    @Override
    public boolean alterar(int idHospedes, Hospede hospede) throws SQLException {
        try {
            String sql = ("UPDATE hospede SET nome=?, data_nascimento=?, sexo=?, cpf=?, telefone=?," +
                    "email=?, senha=? WHERE id=?;");
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, hospede.getNome());
            ps.setDate(2, Date.valueOf(hospede.getDataNascimento()));
            ps.setInt(3, hospede.getSexo().getIndex());
            ps.setString(4, hospede.getCpf());
            ps.setString(5, Integer.toString(hospede.getTelefone()));
            ps.setString(6, hospede.getEmail());
            ps.setString(7, hospede.getSenha());
            ps.setInt(8, idHospedes);

            int retorno = ps.executeUpdate();

            if (retorno == 0) {
                System.out.println("Não foi possível atualizar 'hospede'");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possível atualizar 'hospede'");
        }
        return true;
    }


    @Override
    public boolean deletarPorId(long idHospedes) throws SQLException{
        try {
            String sql = ("DELETE FROM hospede WHERE id="+idHospedes);
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.execute(sql);

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possível deletar registro na tabela 'hospede'");
        }
        return true;
    }

    @Override
    public List<Hospede> listar() throws SQLException{
        try {
            String sql = ("SELECT * FROM hospede;");
            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Hospede> hospedes = new ArrayList<>();

            while (rs.next()) {
                Hospede hospede = new Hospede();
                hospede.setId(rs.getInt("id"));
                hospede.setNome(rs.getString("nome"));
                hospede.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                hospede.setSexo(SexoEnum.binaryToSexoEnum(rs.getInt("sexo")));
                hospede.setCpf(rs.getString("cpf"));
                hospede.setTelefone(Integer.getInteger(rs.getString("telefone")));
                hospede.setEmail(rs.getString("email"));
                hospede.setSenha(rs.getString("senha"));

                hospedes.add(hospede);
            }

            return hospedes;

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new SQLException("Não foi possíveal listar hospedes");
        }

    }
}