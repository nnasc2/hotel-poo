package entidades;

import enums.SexoEnum;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private String cargo;
    private String senha;
    private String status;

    public Funcionario(){}
    public Funcionario(long id, String nome, LocalDate dataNascimento, SexoEnum sexo, String cpf, int telefone, String cargo, String senha, String status){
        super(id, nome, dataNascimento, sexo, cpf, telefone);
        this.cargo = cargo;
        this.senha = senha;
        this.status = status;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
