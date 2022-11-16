package repositorios;

import entidades.Hospede;
import interfaces.repositorio.IRepositorioGenerico;

import java.util.ArrayList;
import java.util.List;

public class HospedeRepositorio implements IRepositorioGenerico<Hospede> {
    private static HospedeRepositorio instance;
    List<Hospede> listaHospedes = new ArrayList<>( );

    public static IRepositorioGenerico<Hospede> getInstance() {

        if (instance == null) {
            instance = new HospedeRepositorio();
        }
        return instance;

    }


    @Override
    public boolean salvar(Hospede usuario) {
        //adicionando usuario a lista, tratamento de exceção utilizado foi o try/catch.//
        try {
            listaHospedes.add(usuario);
        } catch (Exception ex) {
            System.out.println(">>>Error:" + Hospede.class.getName( ) + "messager_error:" + ex.getMessage( ));
            ex.printStackTrace( );
        }
        return true;
    }

    @Override
    public boolean altera(int idHospedes, Hospede usuario) {
        try {
            if (listaHospedes.contains(idHospedes)){
                listaHospedes.set(idHospedes, usuario);
                return true;
            }
        } catch (Exception ex) {
            System.out.println(">>>Error:" + Hospede.class.getName( ) + "messager_error:" + ex.getMessage( ));
            ex.printStackTrace( );
        }
        return false;
    }


    @Override
    public boolean deletarPorId(long idHospedes) {
        try {
            if (listaHospedes.contains(idHospedes)) {
                listaHospedes.remove(idHospedes);
                return true;
            }
        } catch (Exception ex) {
            System.out.println(">>>Error:" + Hospede.class.getName( ) + "messager_error:" + ex.getMessage( ));
            ex.printStackTrace( );
        }
        return false;
    }

    @Override
    public List<Hospede> listar() {
        try {
            return this.listaHospedes;
        } catch (Exception ex) {
            System.out.println(">>>Error:" + Hospede.class.getName( ) + "messager_error:" + ex.getMessage( ));
            ex.printStackTrace( );
            return new ArrayList<Hospede>( );
        }

    }
}