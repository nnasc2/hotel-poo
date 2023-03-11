package interfaces.repositorio;

import entidades.Hotel;

import java.util.List;

public interface IHotelRepositorio {

    boolean salvar(Hotel hotel);
    List<Hotel> listar();
    boolean alterar(long hotelId, Hotel hotel);
    boolean deletar(long hotelId);
}
