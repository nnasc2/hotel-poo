package entidades;

import enums.SexoEnum;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private String cargo;
    private String senha;
    private String status;

    private double salario;

    public Funcionario(){}
    public Funcionario(long id, String nome, LocalDate dataNascimento, SexoEnum sexo, String cpf, String telefone, String cargo, String senha, String status, double salario){
        super(id, nome, dataNascimento, sexo, cpf, telefone);
        this.cargo = cargo;
        this.senha = senha;
        this.status = status;
        this.salario = salario;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
