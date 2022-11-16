package repositorios;

import entidades.Hotel;
import entidades.Quarto;
import entidades.Reserva;
import interfaces.repositorio.IReservaRepositorio;

import java.util.ArrayList;
import java.util.List;

public class ReservaRepositorio implements IReservaRepositorio {
    private static ReservaRepositorio reservaRepositorio;
    private List<Reserva> reservas = new ArrayList<>();

    private ReservaRepositorio() {}

    public static ReservaRepositorio getInstance() {
        if (reservaRepositorio == null) {
            reservaRepositorio = new ReservaRepositorio();
        }
        return reservaRepositorio;
    }
    @Override
    public boolean salvar(Reserva reserva) {
        try{
            reservas.add(reserva);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    @Override
    public List<Reserva> listar() {
            return reservas;
    }

    @Override
    public boolean alterar(long idReserva, Reserva reserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getId() == idReserva) {
                reservas.set(i, reserva);
                break;
            }
        }
        return true;
    }
    @Override
    public boolean deletar(long idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getId() == idReserva) {
                reservas.remove(i);
                break;
            }
        }
        return true;
    }

}
