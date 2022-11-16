package entidades;

import enums.SexoEnum;

public class Pessoa {
    private long id;
    private String nome;
    private SexoEnum sexo;
    private String dataNascimento;
    private String cpf;

    public Pessoa(){}
    public Pessoa(String nome, String cpf) {

        this.nome = nome;

    }

    public Pessoa(String nome, String dataNascimento, SexoEnum sexo, String cpf) {
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


    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
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
}
