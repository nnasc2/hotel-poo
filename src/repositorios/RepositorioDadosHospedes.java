package repositorios;

import entidades.Hospedes;
import interfaces.repositorio.IRepositorioGenerico;

import java.util.ArrayList;
import java.util.List;

public abstract class RepositorioDadosHospedes implements IRepositorioGenerico<Hospedes> {

List<Hospedes> listaHospedes = new ArrayList<>( );



    @Override
    public boolean salvar(Hospedes usuario) {
        //adicionando usuario a lista, tratamento de exceção utilizado foi o try/catch.//
        try {
            listaHospedes.add(usuario);
        } catch (Exception ex) {
            System.out.println (">>>Error:"+ Hospedes.class.getName() + "messager_error:" + ex.getMessage());
            ex.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean altera(int id, Hospedes usuario) {
     try{ if ( listaHospedes.contains(id)){
          listaHospedes.set(id, usuario);
            return true;
      }
     }
     catch (Exception ex){
         System.out.println (">>>Error:"+ Hospedes.class.getName() + "messager_error:" + ex.getMessage());
         ex.printStackTrace();
     }
        return false;
    }


    @Override
    public boolean deletarPorId(long id) {
    try {
        if (listaHospedes.contains(id)) {
            listaHospedes.remove(id);
            return true;
        }
    } catch (Exception ex){
        System.out.println (">>>Error:"+ Hospedes.class.getName() + "messager_error:" + ex.getMessage());
        ex.printStackTrace();
    }
    return false;
    }

    @Override
    public List<Hospedes> listar() {
        try{
            return this.listaHospedes;
        } catch(Exception ex){
            System.out.println (">>>Error:"+ Hospedes.class.getName() + "messager_error:" + ex.getMessage());
            ex.printStackTrace();
            return new ArrayList<Hospedes>();
        }

    }
}
*/
