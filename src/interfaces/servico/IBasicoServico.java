package interfaces.servico;

import java.util.List;

public interface IBasicoServico<Entidade> {
    void salvar(Entidade objeto);
    void alterar(int id, Entidade objeto);
    void deletarPorId(long id);
    List<Entidade> listar();
}
