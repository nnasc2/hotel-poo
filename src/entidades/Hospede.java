package entidades;

import enums.SexoEnum;

import java.time.LocalDate;

public class Hospede extends Pessoa{
    private String email;
    private String senha;

    public Hospede(){}

    public Hospede(long id, String nome, LocalDate dataNascimento, SexoEnum sexo, String cpf,
                   String email, String senha, int telefone) {
        super(id, nome, dataNascimento, sexo, cpf, telefone);
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
