package interfaces.repositorio;

import entidades.Quarto;

import java.sql.SQLException;
import java.util.List;

public interface IQuartoRepositorio {
    boolean salvar (Quarto quarto) throws SQLException;

    List<Quarto> listar() throws SQLException;

    boolean alterar(long idQuarto, Quarto quarto) throws SQLException;

    boolean deletar(long idQuarto) throws SQLException;
}
