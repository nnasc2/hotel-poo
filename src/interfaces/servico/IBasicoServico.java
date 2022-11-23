package interfaces.servico;

import java.util.List;

public interface IBasicoServico<Entidade> {

    public void salvar(Entidade objeto);
    public void alterar(int index, Entidade objeto);

    public default void deletarPorId(long id) {

    }
    public List<Entidade> listar();
    /*para especificações criar arraylistt para a parte*/
}
