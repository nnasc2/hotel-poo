package entidades;

public class Quarto {
    private long id;
    private String tipoQuarto;
    private int tamanhoM2;

    private double diaria;

    private int quantidadePessoa;
    private boolean refeicao;
    private String tipoCama;
   private int numeroCama;
    private int numeroQuarto;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipoCama() {
        return tipoCama;
    }

    public void setTipoCama(String tipoCama) {
        this.tipoCama = tipoCama;
    }

    public int getNumeroCama() {
        return numeroCama;
    }

    public void setNumeroCama(int numeroCama) {
        this.numeroCama = numeroCama;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public int getQuantidadePessoa() {
        return quantidadePessoa;
    }

    public void setQuantidadePessoa(int quantidadePessoa) {
        this.quantidadePessoa = quantidadePessoa;
    }

    public boolean isRefeicao() {
        return refeicao;
    }

    public void setRefeicao(boolean refeicao) {
        this.refeicao = refeicao;
    }

    public int getTamanhoM2() {
        return tamanhoM2;
    }

    public void setTamanhoM2(int tamanhoM2) {
        this.tamanhoM2 = tamanhoM2;
    }

    public double getDiaria() {
        return diaria;
    }

    public void setDiaria(double diaria) {
        this.diaria = diaria;
    }
}
