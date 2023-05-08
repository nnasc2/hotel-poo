package servicos;

import entidades.Quarto;
import entidades.Reserva;
import repositorios.QuartoRepositorio;
import repositorios.ReservaRepositorio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservaServico {

    public ReservaServico(){
    }

    public void cadastrar(Reserva novaReserva) throws SQLException {
        ReservaRepositorio.getInstance().salvar(novaReserva);
    }

    public List<Reserva> listar() throws SQLException {
        List<Reserva> reservas = ReservaRepositorio.getInstance().listar();
        return reservas;
    }

    public List<Reserva> listarPorHospede(long idHospede) throws SQLException {
        List<Reserva> reservas = new ArrayList<>();
        List<Reserva> reservasRepositorio = ReservaRepositorio.getInstance().listar();
        for (int i = 0; i < reservasRepositorio.size(); i++){
            if (reservasRepositorio.get(i).getIdHospede() == idHospede){
                reservas.add(reservasRepositorio.get(i));
            }
        }
        return reservas;
    }

    public List<Reserva> listarPorQuarto(int numeroQuarto) throws SQLException {
        List<Reserva> reservas = new ArrayList<>();
        List<Reserva> reservasRepositorio = ReservaRepositorio.getInstance().listar();
        for (int i = 0; i < reservasRepositorio.size(); i++){
            if (reservasRepositorio.get(i).getNumQuarto() == numeroQuarto){
                reservas.add(reservasRepositorio.get(i));
            }
        }
        return reservas;
    }

    void alterar(long idReserva, Reserva reserva) throws SQLException {
        ReservaRepositorio.getInstance().alterar(idReserva, reserva);
    }
    void deletar(long idReserva) throws SQLException {
        ReservaRepositorio.getInstance().deletar(idReserva);
    }
}
