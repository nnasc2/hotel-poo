package repositorios;

import entidades.Pagamento;
import enums.PagamentoEnum;
import interfaces.repositorio.IRepositorioGenerico;
import util.ConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagamentoRepositorio implements IRepositorioGenerico<Pagamento> {

    private static PagamentoRepositorio instance;
    private Connection conexao;

    private PagamentoRepositorio() throws SQLException {
        this.conexao = ConnectionSingleton.getInstance().conexao;
    }

    public static PagamentoRepositorio getInstance() throws SQLException {
        if (instance == null) {
            instance = new PagamentoRepositorio();
        }
        return instance;
    }

    @Override
    public boolean salvar(Pagamento pagamento) throws SQLException {
        try {
            String sql = ("INSERT INTO pagamento (forma_pagamento, valor, status, data_vencimento, id_hospede)" +
                    "values(?,?,?,?,?);");
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, pagamento.getFormaPagamento().getIndex());
            ps.setDouble(2, pagamento.getValor());
            ps.setString(3, pagamento.getStatus());
            ps.setDate(4, Date.valueOf(pagamento.getDataVencimento()));
            ps.setLong(5, pagamento.getIdHospede());

            int retorno = ps.executeUpdate();

            if (retorno == 0) {
                System.out.println("Não foi possível persistir 'pagamento'");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possível persistir 'pagamento'");
        }
        return true;
    }

    @Override
    public boolean alterar(int idPagamentos, Pagamento pagamento) throws SQLException {
        try {
            String sql = ("UPDATE pagamento SET forma_pagamento=?, valor=?, status=?," +
                    "data_nascimento=?, id_hospede=? WHERE id=?;");
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, pagamento.getFormaPagamento().getIndex());
            ps.setDouble(2, pagamento.getValor());
            ps.setString(3, pagamento.getStatus());
            ps.setDate(4, Date.valueOf(pagamento.getDataVencimento()));
            ps.setLong(5, pagamento.getIdHospede());
            ps.setInt(6, idPagamentos);

            int retorno = ps.executeUpdate();

            if (retorno == 0) {
                System.out.println("Não foi possível atualizar 'pagamento'");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possível atualizar 'pagamento'");
        }
        return true;
    }


    @Override
    public boolean deletarPorId(long idPagamento) throws SQLException {
        try {
            String sql = ("DELETE FROM pagamento WHERE id=?;");
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, (int) idPagamento);

            boolean retorno = ps.execute(sql);

            if (!retorno) {
                System.out.println("Não foi possível deletar registro na tabela 'pagamento'");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possível deletar registro na tabela 'pagamento'");
        }
        return true;
    }

    @Override
    public List<Pagamento> listar() throws SQLException {
        try {
            String sql = ("SELECT * FROM pagamento;");
            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Pagamento> pagamentos = new ArrayList<>();

            while (rs.next()) {
                Pagamento pagamento = new Pagamento();
                pagamento.setId(rs.getInt("id"));
                pagamento.setFormaPagamento(PagamentoEnum.intToPagamentoEnum(rs.getInt("forma_pagamento")));
                pagamento.setValor(rs.getDouble("valor"));
                pagamento.setStatus(rs.getString("status"));
                pagamento.setDataVencimento(rs.getDate("data_vencimento").toLocalDate());
                pagamento.setIdHospede(rs.getLong("id_hospede"));

                pagamentos.add(pagamento);
            }

            return pagamentos;

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new SQLException("Não foi possíveal listar pagamentos");
        }
    }
}
