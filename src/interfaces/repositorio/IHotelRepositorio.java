package interfaces.repositorio;

import entidades.Hotel;

import java.util.List;

public interface IHotelRepositorio {

    public boolean salvar(Hotel hotel);
    public List<Hotel> retornar();
    public boolean alterar(long hotelId, Hotel hotel);
    public boolean deletar(long hotelId);
}
