package interfaces.repositorio;

import entidades.Hotel;

import java.sql.SQLException;
import java.util.List;

public interface IHotelRepositorio {

    boolean salvar(Hotel hotel) throws SQLException;
    List<Hotel> listar() throws SQLException;
    boolean alterar(long hotelId, Hotel hotel) throws SQLException;
    boolean deletar(long hotelId) throws SQLException;
}
