package repositorio;

import entidade.Funcionarios;
import entidade.Hospedes;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDadosFuncionarios implements IRepositorioGenerico <Funcionarios> {
    List<Funcionarios> listaFuncionarios = new ArrayList<>( );



    @Override
    public boolean salvar(Funcionarios funcionario) {
        //adicionando usuario a lista, tratamento de exceção utilizado foi o try/catch.//
        try {
            listaFuncionarios.add(funcionario);
        } catch (Exception ex) {
            System.out.println (">>>Error:"+ Funcionarios.class.getName() + "messager_error:" + ex.getMessage());
            ex.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean altera(int id, Funcionarios funcionario) {
        try{ if ( listaFuncionarios.contains(id)){
            listaFuncionarios.set(id, funcionario );
            return true;
        }
        }
        catch (Exception ex){
            System.out.println (">>>Error:"+ Funcionarios.class.getName() + "messager_error:" + ex.getMessage());
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
            System.out.println (">>>Error:"+ Funcionarios.class.getName() + "messager_error:" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Funcionarios> listar() {
        try{
            return this.listaFuncionarios;
        } catch(Exception ex){
            System.out.println (">>>Error:"+ Funcionarios.class.getName() + "messager_error:" + ex.getMessage());
            ex.printStackTrace();
            return new ArrayList<Funcionarios>();
        }

    }
}



