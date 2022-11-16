package servicos;

import entidades.Quarto;
import entidades.Reserva;
import repositorios.QuartoRepositorio;
import repositorios.ReservaRepositorio;

import java.util.ArrayList;
import java.util.List;

public class ReservaServico {

    public ReservaServico(){
    }

    public void cadastrar(Reserva novaReserva){
        ReservaRepositorio.getInstance().salvar(novaReserva);
    }

    public List<Reserva> listar(){
        List<Reserva> reservas = ReservaRepositorio.getInstance().listar();
        return reservas;
    }

    public List<Reserva> listarPorHospede(long idHospede){
        List<Reserva> reservas = new ArrayList<>();
        List<Reserva> reservasRepositorio = ReservaRepositorio.getInstance().listar();
        for (int i = 0; i < reservasRepositorio.size(); i++){
            if (reservasRepositorio.get(i).getIdHospede() == idHospede){
                reservas.add(reservasRepositorio.get(i));
            }
        }
        return reservas;
    }

    public List<Reserva> listarPorQuarto(int numeroQuarto){
        List<Reserva> reservas = new ArrayList<>();
        List<Reserva> reservasRepositorio = ReservaRepositorio.getInstance().listar();
        for (int i = 0; i < reservasRepositorio.size(); i++){
            if (reservasRepositorio.get(i).getNumQuarto() == numeroQuarto){
                reservas.add(reservasRepositorio.get(i));
            }
        }
        return reservas;
    }

    void alterar(long idReserva, Reserva reserva){
        ReservaRepositorio.getInstance().alterar(idReserva, reserva);
    }
    void deletar(long idReserva){
        ReservaRepositorio.getInstance().deletar(idReserva);
    }
}
