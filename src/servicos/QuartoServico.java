package servicos;

import entidades.Quarto;
import interfaces.servico.IQuartoServico;
import repositorios.QuartoRepositorio;
import repositorios.ReservaRepositorio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuartoServico implements IQuartoServico {
    @Override
    public void cadastrar(Quarto quarto) throws SQLException {
        QuartoRepositorio.getInstance().salvar(quarto);
    }

    @Override
    public List<Quarto> listar() throws SQLException {
        List<Quarto> quartos = QuartoRepositorio.getInstance().listar();
        return quartos;
    }

    public Quarto listar(int numeroQuarto){
        for (int i = 0; i < listar().size(); i++)
            if (listar().get(i).getNumeroQuarto() == numeroQuarto)
                return listar().get(i);
        return null;
    }

    public List<Quarto> listarPorHotel(long idHotel) {
        List<Quarto> quartos = new ArrayList<>();
        List<Quarto> quartosRepositorio = QuartoRepositorio.getInstance().listar();
        for(int i = 0; i < quartosRepositorio.size(); i++){
            if(quartosRepositorio.get(i).getHotelId() == idHotel){
                quartos.add(quartosRepositorio.get(i));
            }
        }
        return quartos;
    }

    public Quarto listarPorId(long idQuarto){
        Quarto quarto = new Quarto();
        List<Quarto> quartosRepositorio = QuartoRepositorio.getInstance().listar();
        for (int i = 0; i < quartosRepositorio.size(); i++){
            if (quartosRepositorio.get(i).getId() == idQuarto){
                quarto = quartosRepositorio.get(i);
            }
        }
        return quarto;
    }

    @Override
    public void alterar(long idQuarto, Quarto quarto) throws SQLException {
        QuartoRepositorio.getInstance().alterar(idQuarto, quarto);
    }

    @Override
    public void deletar(long idQuarto) {
        ReservaRepositorio.getInstance().deletar(idQuarto);
    }

    public boolean verificarDisponibilidadeQuarto(int numeroQuarto){
        List<Quarto> quartos = new ArrayList<>(listar());
        boolean retorno = false;
        for (Quarto q: quartos){
            if (q.getNumeroQuarto() == numeroQuarto){
                retorno = q.isOperante();
            }
        }
        return retorno;
    }
}
