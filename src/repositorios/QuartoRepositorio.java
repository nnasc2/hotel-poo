package repositorios;

import entidades.Quarto;
import enums.QuartoEnum;
import interfaces.repositorio.IQuartoRepositorio;
import util.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuartoRepositorio implements IQuartoRepositorio {
    private static QuartoRepositorio instance;
    private Connection conexao;

    private QuartoRepositorio() throws SQLException {
        this.conexao = ConnectionSingleton.getInstance().conexao;
    }

    public static QuartoRepositorio getInstance() throws SQLException{
        if (instance == null){
            instance = new QuartoRepositorio();
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
    public boolean salvar(Quarto quarto) throws SQLException {
        try {
            String sql = ("INSERT INTO quarto (numero, tipo, area, diaria, operante, refeicao, desc_cama," +
                    "ocup_maxima, andar, id_hotel) values(?,?,?,?,?,?,?,?,?,?);");
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, quarto.getNumeroQuarto());
            ps.setInt(2, quarto.getTipoQuarto().getIndex());
            ps.setInt(3, quarto.getArea());
            ps.setDouble(4, quarto.getDiaria());
            ps.setInt(5, (quarto.isOperante() ? 1 : 0));
            ps.setInt(6, (quarto.isRefeicao() ? 1 : 0));
            ps.setString(7, quarto.getDescricaoCama());
            ps.setInt(8, quarto.getOcupacaoMaxima());
            ps.setInt(9, quarto.getAndar());
            ps.setInt(10, (int) quarto.getHotelId());

            int retorno = ps.executeUpdate();

            if (retorno == 0) {
                System.out.println("Não foi possível persistir Quarto");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possível persistir Quarto");
        }
        return true;
    }

    @Override
    public List<Quarto> listar()  throws SQLException{
        try {
            String sql = ("SELECT * FROM quarto;");
            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Quarto> quartos = new ArrayList<>();

            while(rs.next()){
                Quarto quarto = new Quarto();
                quarto.setId(rs.getInt("id"));
                quarto.setNumeroQuarto(rs.getInt("numero"));
                quarto.setTipoQuarto(QuartoEnum.intToQuartoEnum(rs.getInt("tipo")));
                quarto.setArea(rs.getInt("area"));
                quarto.setDiaria(rs.getDouble("diaria"));
                quarto.setOperante(binaryToBoolean(rs.getInt("operante")));
                quarto.setRefeicao(binaryToBoolean(rs.getInt("refeicao")));
                quarto.setDescricaoCama(rs.getString("desc_cama"));
                quarto.setOcupacaoMaxima(rs.getInt("ocup_maxima"));
                quarto.setAndar(rs.getInt("andar"));
                quarto.setHotelId(rs.getInt("id_hotel"));

                quartos.add(quarto);
            }

            return quartos;

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possíveal listar Quartos");
        }
    }

    public List<Quarto> listarOperantes()  throws SQLException{
        try {
            String sql = ("SELECT * FROM quarto WHERE operante=1;");
            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Quarto> quartos = new ArrayList<>();

            while(rs.next()){
                Quarto quarto = new Quarto();
                quarto.setId(rs.getInt("id"));
                quarto.setNumeroQuarto(rs.getInt("numero"));
                quarto.setTipoQuarto(QuartoEnum.intToQuartoEnum(rs.getInt("tipo")));
                quarto.setArea(rs.getInt("area"));
                quarto.setDiaria(rs.getDouble("diaria"));
                quarto.setOperante(binaryToBoolean(rs.getInt("operante")));
                quarto.setRefeicao(binaryToBoolean(rs.getInt("refeicao")));
                quarto.setDescricaoCama(rs.getString("desc_cama"));
                quarto.setOcupacaoMaxima(rs.getInt("ocup_maxima"));
                quarto.setAndar(rs.getInt("andar"));
                quarto.setHotelId(rs.getInt("id_hotel"));

                quartos.add(quarto);
            }

            return quartos;

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possível listar Quartos operantes");
        }
    }

    @Override
    public boolean alterar(long idQuarto, Quarto quarto)  throws SQLException{
        try {
            String sql = ("UPDATE quarto SET numero=?, tipo=?, area=?, diaria=?, operante=?, refeicao=?, desc_cama=?," +
                    "ocup_maxima=?, andar=?, id_hotel=? WHERE id=?;");
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, quarto.getNumeroQuarto());
            ps.setInt(2, quarto.getTipoQuarto().getIndex());
            ps.setInt(3, quarto.getArea());
            ps.setDouble(4, quarto.getDiaria());
            ps.setInt(5, (quarto.isOperante() ? 1 : 0));
            ps.setInt(6, (quarto.isRefeicao() ? 1 : 0));
            ps.setString(7, quarto.getDescricaoCama());
            ps.setInt(8, quarto.getOcupacaoMaxima());
            ps.setInt(9, quarto.getAndar());
            ps.setInt(10, (int) quarto.getHotelId());
            ps.setInt(11, (int) idQuarto);

            int retorno = ps.executeUpdate();

            if (retorno == 0) {
                System.out.println("Não foi possível alterar Quarto");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possível alterar Quarto");
        }
        return true;
    }

    @Override
    public boolean deletar(long idQuarto)  throws SQLException{
        try {
            String sql = ("DELETE FROM quarto WHERE id="+idQuarto);
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.execute(sql);

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            throw new SQLException("Não foi possível deletar Quarto");
        }
        return true;
    }
}
