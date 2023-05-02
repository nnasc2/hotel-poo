package repositorios;

import entidades.Hotel;
import entidades.Quarto;
import enums.ClassificacaoEnum;
import enums.QuartoEnum;
import interfaces.repositorio.IHotelRepositorio;
import util.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public boolean binaryToBoolean(int num){
        return switch (num){
            case 0 -> false;
            case 1 -> true;
            default -> false;
        };
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
        try {
            String sql = ("SELECT * FROM hotel;");
            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Hotel> hoteis = new ArrayList<>();

            while(rs.next()){
                Hotel hotel = new Hotel();
                hotel.setId(rs.getInt("id"));
                hotel.setNome(rs.getString("nome"));
                hotel.setDescricao(rs.getString("descricao"));
                hotel.setClassificacao(ClassificacaoEnum.intToClassificacaoEnum(rs.getInt("classificacao")));
                hotel.setEstado(rs.getString("estado"));
                hotel.setCidade(rs.getString("cidade"));
                hotel.setBairro(rs.getString("bairro"));
                hotel.setComplemento(rs.getString("complemento"));
                hotel.setNumero(rs.getInt("numero"));
                hotel.setCnpj(rs.getString("cnpj"));

                hoteis.add(hotel);
            }

            return hoteis;

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possíveal listar hoteis");
        }
    }

    @Override
    public boolean alterar(long hotelId, Hotel hotel)  throws SQLException{
        try {
            String sql = ("UPDATE hotel SET nome=?, descricao=?, classificacao=?, estado=?, cidade=?, rua=?, bairro=?," +
                    "complemento=?, numero=?, cnpj=? WHERE id=?;");
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
            ps.setInt(11, (int) hotel.getId());

            int retorno = ps.executeUpdate();

            if (retorno == 0) {
                System.out.println("Não foi possível alterar registro na tabela 'hotel'");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possível alterar registro na tabela 'hotel'");
        }
        return true;
    }

    @Override
    public boolean deletar(long hotelId)  throws SQLException{
        try {
            String sql = ("DELETE FROM hotel WHERE id=?;");
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, (int) hotelId);

            boolean retorno = ps.execute(sql);

            if (!retorno) {
                System.out.println("Não foi possível deletar registro na tabela 'hotel'");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possível deletar registro na tabela 'hotel'");
        }
        return true;
    }
}
