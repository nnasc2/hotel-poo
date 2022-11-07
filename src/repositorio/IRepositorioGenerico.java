package repositorio;

import entidade.Hospedes;

import java.util.List;

public interface IRepositorioGenerico<Entidade>{
    public boolean salvar(Entidade usuario);

    public boolean altera(int index, Entidade usuario);
    public boolean deletarPorId(long id);
    public List<Entidade> listar();
    /*para especificações criar arraylistt para a parte*/
}
