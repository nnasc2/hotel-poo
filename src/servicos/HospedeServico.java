package servicos;

import entidades.Hospede;
import enums.SexoEnum;

import interfaces.servico.IBasicoServico;
import repositorios.HospedeRepositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HospedeServico implements IBasicoServico<Hospede> {
    public void cadastrar(String nome, SexoEnum sexo, LocalDate dataNascimento, String cpf, long idHospede, String email, String senha, int telefone) {
        try{
            Hospede novoHospede = new Hospede();
            novoHospede.setId(idHospede);
            novoHospede.setNome(nome);
            novoHospede.setCpf(cpf);
            novoHospede.setDataNascimento(dataNascimento);
            novoHospede.setSexo(sexo);
            novoHospede.setTelefone(telefone);
            novoHospede.setEmail(email);
            novoHospede.setSenha(senha);
            HospedeRepositorio.getInstance().salvar(novoHospede);
        }catch (Exception e){
            System.out.println("Error:"+e.getMessage());
        }

    }


    @Override
    public void salvar(Hospede objeto) {
        HospedeRepositorio.getInstance().salvar(objeto);
    }

    @Override
    public void alterar(int id, Hospede objeto) {
        HospedeRepositorio.getInstance().alterar(id, objeto);
    }

    @Override
    public List<Hospede> listar() {
        List<Hospede> hospedes = new ArrayList<>(HospedeRepositorio.getInstance().listar());
        return hospedes;
    }

    @Override
    public void deletarPorId(long idHospede) {
        HospedeRepositorio.getInstance().deletarPorId(idHospede);
    }
}

