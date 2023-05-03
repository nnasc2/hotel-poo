package interfaces.repositorio;

import java.sql.SQLException;
import java.util.List;

public interface IRepositorioGenerico<Entidade>{
    boolean salvar(Entidade usuario) throws SQLException;

    boolean alterar(int index, Entidade usuario) throws SQLException;
    boolean deletarPorId(long id) throws SQLException;
    List<Entidade> listar() throws SQLException;
    /*para especificações criar arraylistt para a parte*/
}
