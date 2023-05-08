package repositorios;

import entidades.Reserva;
import interfaces.repositorio.IReservaRepositorio;
import util.ConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaRepositorio implements IReservaRepositorio {
    private static ReservaRepositorio instance;
    public Connection conexao;

    private ReservaRepositorio() throws SQLException {
        this.conexao = ConnectionSingleton.getInstance().conexao;
    }

    public static ReservaRepositorio getInstance() throws SQLException {
        if (instance == null) {
            instance = new ReservaRepositorio();
        }
        return instance;
    }
    @Override
    public boolean salvar(Reserva reserva) throws SQLException {
        try {
            String sql = ("INSERT INTO reserva (data_inicio, data_fim, data_checkin, data_checkout, id_hotel," +
                    "id_hospede, num_quarto, valor) values(?,?,?,?,?,?,?,?);");
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(reserva.getDataInicio()));
            ps.setDate(2, Date.valueOf(reserva.getDataFim()));
            ps.setDate(3, Date.valueOf(reserva.getDataCheckin()));
            ps.setDate(4, Date.valueOf(reserva.getDataCheckout()));
            ps.setInt(5, (int) reserva.getIdHotel());
            ps.setInt(6, (int) reserva.getIdHospede());
            ps.setInt(7, reserva.getNumQuarto());
            ps.setDouble(8, reserva.getValor());

            int retorno = ps.executeUpdate();

            if (retorno == 0) {
                System.out.println("Não foi possível persistir 'reserva'");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possível persistir 'reserva'");
        }
        return true;
    }

    @Override
    public List<Reserva> listar() throws SQLException{
        try {
            String sql = ("SELECT * FROM reserva;");
            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Reserva> reservas = new ArrayList<>();

            while(rs.next()){
                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("id"));
                reserva.setDataInicio(rs.getDate("data_inicio").toLocalDate());
                reserva.setDataFim(rs.getDate("data_fim").toLocalDate());
                reserva.setDataCheckin(rs.getDate("data_checkin").toLocalDate());
                reserva.setDataCheckout(rs.getDate("data_checkout").toLocalDate());
                reserva.setIdHotel(rs.getInt("id_hotel"));
                reserva.setIdHospede(rs.getInt("id_hospede"));
                reserva.setNumQuarto(rs.getInt("num_quarto"));
                reserva.setValor(rs.getDouble("valor"));

                reservas.add(reserva);
            }

            return reservas;

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possíveal listar reservas");
        }
    }

    @Override
    public boolean alterar(long idReserva, Reserva reserva) throws SQLException{
        try {
            String sql = ("UPDATE reserva SET data_inicio=?, data_fim=?, data_checkin=?, data_checkout=?, id_hotel=?," +
                    "id_hospede=?, num_quarto=?, valor=? WHERE id=?;");
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(reserva.getDataInicio()));
            ps.setDate(2, Date.valueOf(reserva.getDataFim()));
            ps.setDate(3, Date.valueOf(reserva.getDataCheckin()));
            ps.setDate(4, Date.valueOf(reserva.getDataCheckout()));
            ps.setInt(5, (int) reserva.getIdHotel());
            ps.setInt(6, (int) reserva.getIdHospede());
            ps.setInt(7, reserva.getNumQuarto());
            ps.setDouble(8, reserva.getValor());
            ps.setInt(9, (int) idReserva);

            int retorno = ps.executeUpdate();

            if (retorno == 0) {
                System.out.println("Não foi possível atualizar 'reserva'");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possível atualizar 'reserva'");
        }
        return true;
    }
    @Override
    public boolean deletar(long idReserva) throws SQLException{
        try {
            String sql = ("DELETE FROM reserva WHERE id="+idReserva);
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.execute(sql);

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possível deletar registro na tabela 'reserva'");
        }
        return true;
    }

}
