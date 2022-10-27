package repositorio;

import entidade.Hospedes;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDadosHospedes implements IRepositorioGenerico<Hospedes> {

List<Hospedes> listaUsuarios = new ArrayList<>( );



    @Override
    public boolean salvar(Hospedes usuario) {
        //adicionando usuario a lista, tratamento de exceção utilizado foi o try/catch.//
        try {
            listaUsuarios.add(usuario);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean altera(Hospedes usuario) {
        return false;
    }

    @Override
    public boolean deletarPorId(long id) {
        return false;
    }

    @Override
    public List<Hospedes> listar() {
        return listaUsuarios;
    }
}
