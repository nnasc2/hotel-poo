package interfaces.repositorio;

import entidades.Reserva;

import java.sql.SQLException;
import java.util.List;

public interface IReservaRepositorio {
    boolean salvar(Reserva reserva) throws SQLException;

    List<Reserva> listar() throws SQLException;

    boolean alterar(long idReserva, Reserva reserva) throws SQLException;

    boolean deletar(long idReserva) throws SQLException;

}
