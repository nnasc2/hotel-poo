package repositorios;

import entidades.Hotel;
import interfaces.repositorio.IHotelRepositorio;
import util.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelRepositorio implements IHotelRepositorio {
    private static HotelRepositorio instance;
    public Connection conexao;

    private HotelRepositorio ()  throws SQLException{
        this.conexao = ConnectionSingleton.getInstance().conexao;
    }

    public static HotelRepositorio getInstance()  throws SQLException{
        if (instance == null) {
            instance = new HotelRepositorio();
        }
        return instance;
    }

    @Override
    public boolean salvar(Hotel hotel) throws SQLException{
        try {
            String sql = ("INSERT INTO hotel (nome, descricao, classificacao, estado, cidade, rua, bairro," +
                    "complemento, numero, cnpj)");
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, hotel.getNome());
            ps.setString(2, hotel.getDescricao());
            ps.setInt(3, hotel.getClassificacao().getValue());
            ps.setString(4, hotel.getEstado());
            ps.setString(5, hotel.getCidade());
            ps.setString(6, hotel.getRua());
            ps.setString(7, hotel.getBairro());
            ps.setString(8, hotel.getComplemento());
            ps.setInt(9, hotel.getNumero());
            ps.setString(10, hotel.getCnpj());

            int retorno = ps.executeUpdate();

            if (retorno == 0) {
                throw new SQLException("Não foi possível persistir Hotel");
            }

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possível persistir Hotel");
        }
        return true;
    }

    @Override
    public List<Hotel> listar()  throws SQLException{
        return hoteisRepositorio;
    }

    @Override
    public boolean alterar(long hotelId, Hotel hotel)  throws SQLException{
        try{
            for (int i = 0; i < hoteisRepositorio.size(); i++) {
                if (hoteisRepositorio.get(i).getId() == hotelId) {
                    hoteisRepositorio.set(i, hotel);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deletar(long hotelId)  throws SQLException{
        try{
            for (int i = 0; i < hoteisRepositorio.size(); i++) {
                if (hoteisRepositorio.get(i).getId() == hotelId) {
                    hoteisRepositorio.remove(i);
                    break;
                }
            }
        } catch(Exception e) {
            System.out.println("Error:"+e.getMessage());
            return false;
        }
        return true;
    }
}
