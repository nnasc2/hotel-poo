package interfaces.repositorio;

import entidades.Quarto;

import java.util.List;

public interface IQuartoRepositorio {
    boolean salvar(Quarto quarto);

    List<Quarto> listar();

    boolean alterar(long idQuarto, Quarto quarto);

    boolean deletar(long idQuarto);
}
