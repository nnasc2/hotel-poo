package repositorios;

import entidades.Quarto;
import interfaces.repositorio.IQuartoRepositorio;

import java.util.ArrayList;
import java.util.List;

public class QuartoRepositorio implements IQuartoRepositorio {
    private static QuartoRepositorio quartoRepositorio;
    private List<Quarto> quartos = new ArrayList<>();

    private QuartoRepositorio(){}

    public static QuartoRepositorio getInstance(){
        if(quartoRepositorio == null){
            quartoRepositorio = new QuartoRepositorio();
        }
        return quartoRepositorio;
    }

    @Override
    public boolean salvar(Quarto quarto) {
        if (quartos.size() <= 3){
            quartos.add(quarto);
        }
        return true;
    }

    @Override
    public List<Quarto> listar() {
        return quartos;
    }

    @Override
    public boolean alterar(long idQuarto, Quarto quarto) {
        for (int i = 0; i < quartos.size(); i++) {
            if (quartos.get(i).getId() == idQuarto) {
                quartos.set(i, quarto);
                break;
            }
        }
        return true;
    }

    @Override
    public boolean deletar(long idQuarto) {
        for (int i = 0; i < quartos.size(); i++) {
            if (quartos.get(i).getId() == idQuarto) {
                quartos.remove(i);
                break;
            }
        }
        return true;
    }
}
