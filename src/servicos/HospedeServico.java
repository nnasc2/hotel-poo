package servicos;

import entidades.Hospede;
import enums.SexoEnum;

import interfaces.servico.IBasicoServico;
import repositorios.HospedeRepositorio;

import java.util.List;

public class HospedeServico implements IBasicoServico<Hospede> {
    public void cadastrar(String nome, SexoEnum sexo, String dataNascimento, String cpf, long idHospede,String email, String senha, int telefone, String login) {
        try{
            Hospede novoHospede = new Hospede(nome, cpf);
            novoHospede.setIdHospede(idHospede);
            novoHospede.setDataNascimento(dataNascimento);
            novoHospede.setSexo(sexo);
            novoHospede.setTelefone(telefone);
            novoHospede.setEmail(email);
            novoHospede.setLogin(login);
            novoHospede.setSenha(senha);

            HospedeRepositorio.getInstance().salvar(novoHospede);
        }catch (Exception e){
            System.out.println("Error:"+e.getMessage());
        }

    }


    @Override
    public void salvar(Hospede usuario) {

    }

    @Override
    public void alterar(int index, Hospede usuario) {


    }

    @Override
    public List<Hospede> listar() {
        return null;
    }

    @Override
    public void deletarPorId(long idHospedes) {
        interfaces.servico.IBasicoServico.super.deletarPorId(idHospedes);
    }
}

