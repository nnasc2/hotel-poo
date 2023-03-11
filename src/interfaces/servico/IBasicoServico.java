package interfaces.servico;

import java.util.List;

public interface IBasicoServico<Entidade> {

    void salvar(Entidade objeto);
    void alterar(int index, Entidade objeto);

    default void deletarPorId(long id) {

    }
    List<Entidade> listar();
    /*para especificações criar arraylistt para a parte*/
}
