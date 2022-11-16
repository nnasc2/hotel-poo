package interfaces.servico;

import entidades.Reserva;

import java.util.List;

public interface IReservaServico {
    void cadastrar(Reserva novaReserva);
    List<Reserva> listar();
    void alterar(long idReserva, Reserva reserva);
    void deletar(long idReserva);
}
