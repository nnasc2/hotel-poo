package interfaces.servico;

import entidades.Funcionario;

import java.sql.SQLException;
import java.util.List;

public interface IBasicoServico<Entidade> {
    void salvar(Entidade objeto) throws SQLException;
    void alterar(int id, Entidade objeto) throws SQLException;
    void deletarPorId(long id) throws SQLException;
    List<Entidade> listar() throws SQLException;
}
