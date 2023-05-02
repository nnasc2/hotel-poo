package interfaces.servico;

import entidades.Quarto;

import java.sql.SQLException;
import java.util.List;

public interface IQuartoServico {
    void cadastrar(Quarto quarto) throws SQLException;
    List<Quarto> listar() throws SQLException;
    void alterar(long idQuarto, Quarto quarto) throws SQLException;
    void deletar(long idQuarto);
}
