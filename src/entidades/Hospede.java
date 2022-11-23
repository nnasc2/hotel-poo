package entidades;

import enums.SexoEnum;

public class Hospede extends Pessoa{
  private  long idHospede;
  private String email;
  private String senha;
  private int telefone;
  private String login;

    public Hospede(String nome, String dataNascimento, SexoEnum sexo, String cpf,
                   long idHospede, String email, String senha, int telefone, String login) {
        super(nome, dataNascimento, sexo, cpf);
        this.idHospede = idHospede;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.login = login;
    }
    public Hospede(){}

    public Hospede(String nome, String cpf) {
        super (nome, cpf);
    }

    public long getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(long idHospede) {
        this.idHospede = idHospede;
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

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
