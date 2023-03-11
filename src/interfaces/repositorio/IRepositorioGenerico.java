package interfaces.repositorio;

import java.util.List;

public interface IRepositorioGenerico<Entidade>{
    boolean salvar(Entidade usuario);

    boolean alterar(int index, Entidade usuario);
    boolean deletarPorId(long id);
    List<Entidade> listar();
    /*para especificações criar arraylistt para a parte*/
}
