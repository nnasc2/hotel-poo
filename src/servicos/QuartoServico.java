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

    public Quarto listar(int numeroQuarto) throws SQLException {
        for (int i = 0; i < listar().size(); i++)
            if (listar().get(i).getNumeroQuarto() == numeroQuarto)
                return listar().get(i);
        return null;
    }

    public List<Quarto> listarPorHotel(long idHotel) throws SQLException {
        List<Quarto> quartos = new ArrayList<>();
        List<Quarto> quartosRepositorio = QuartoRepositorio.getInstance().listar();
        for(int i = 0; i < quartosRepositorio.size(); i++){
            if(quartosRepositorio.get(i).getHotelId() == idHotel){
                quartos.add(quartosRepositorio.get(i));
            }
        }
        return quartos;
    }

    public Quarto listarPorId(long idQuarto) throws SQLException {
        Quarto quarto = new Quarto();
        List<Quarto> quartosRepositorio = QuartoRepositorio.getInstance().listar();
        for (int i = 0; i < quartosRepositorio.size(); i++){
            if (quartosRepositorio.get(i).getId() == idQuarto){
                quarto = quartosRepositorio.get(i);
            }
        }
        return quarto;
    }

    public List<Quarto> listarOperantes() throws SQLException {
        return QuartoRepositorio.getInstance().listarOperantes();
    }

    @Override
    public void alterar(long idQuarto, Quarto quarto) throws SQLException {
        QuartoRepositorio.getInstance().alterar(idQuarto, quarto);
    }

    @Override
    public void deletar(long idQuarto) throws SQLException {
        QuartoRepositorio.getInstance().deletar(idQuarto);
    }

    public boolean verificarDisponibilidadeQuarto(int numeroQuarto) throws SQLException {
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
