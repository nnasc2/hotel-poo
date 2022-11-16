package interfaces.servico;

import java.util.List;

public interface IBasicoServico<Entidade> {

    public void salvar(Entidade usuario);
    public void alterar(int index, Entidade usuario);

    public default void deletarPorId(long id) {

    }

    public List<Entidade> listar();
    /*para especificações criar arraylistt para a parte*/
}
