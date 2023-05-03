package entidades;

import enums.SexoEnum;

import java.time.LocalDate;

abstract public class Pessoa {
    private long id;
    private String nome;
    private SexoEnum sexo;
    private LocalDate dataNascimento;
    private String cpf;
    private int telefone;

    public Pessoa(){}
    public Pessoa(long id, String nome, LocalDate dataNascimento, SexoEnum sexo, String cpf, int telefone) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSexo(SexoEnum sexo) {
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}
