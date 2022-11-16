package repositorios;

import entidades.Funcionario;
import interfaces.repositorio.IRepositorioGenerico;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepositorio implements IRepositorioGenerico<Funcionario> {
    List<Funcionario> listaFuncionarios = new ArrayList<>( );



    @Override
    public boolean salvar(Funcionario funcionario) {
        //adicionando usuario a lista, tratamento de exceção utilizado foi o try/catch.//
        try {
            listaFuncionarios.add(funcionario);
        } catch (Exception ex) {
            System.out.println (">>>Error:"+ Funcionario.class.getName() + "messager_error:" + ex.getMessage());
            ex.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean altera(int id, Funcionario funcionario) {
        try{ if ( listaFuncionarios.contains(id)){
            listaFuncionarios.set(id, funcionario );
            return true;
        }
        }
        catch (Exception ex){
            System.out.println (">>>Error:"+ Funcionario.class.getName() + "messager_error:" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean deletarPorId(long id) {
        try {
            if (listaFuncionarios.contains(id)) {
                listaFuncionarios.remove(id);
                return true;
            }
        } catch (Exception ex){
            System.out.println (">>>Error:"+ Funcionario.class.getName() + "messager_error:" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Funcionario> listar() {
        try{
            return this.listaFuncionarios;
        } catch(Exception ex){
            System.out.println (">>>Error:"+ Funcionario.class.getName() + "messager_error:" + ex.getMessage());
            ex.printStackTrace();
            return new ArrayList<Funcionario>();
        }

    }
}



