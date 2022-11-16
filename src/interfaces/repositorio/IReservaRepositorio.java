package interfaces.repositorio;

import entidades.Reserva;

import java.util.List;

public interface IReservaRepositorio {
    boolean salvar(Reserva reserva);

    List<Reserva> listar();

    boolean alterar(long idReserva, Reserva reserva);

    boolean deletar(long idReserva);

}
