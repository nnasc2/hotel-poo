package entidades;

public class Quarto {
    private long id;
    private String tipoQuarto;
    private int metrosQuadrados;

    private double diaria;

    private boolean ocupado;

    private int maximoPessoas;
    private boolean refeicao;
    private String tipoCama;
    private int numeroCama;
    private int numeroQuarto;
    private long hotelId;


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

    public int getMaximoPessoas() {
        return maximoPessoas;
    }

    public void setMaximoPessoas(int maximoPessoas) {
        this.maximoPessoas = maximoPessoas;
    }

    public boolean isRefeicao() {
        return refeicao;
    }

    public void setRefeicao(boolean refeicao) {
        this.refeicao = refeicao;
    }

    public int getMetrosQuadrados() {
        return metrosQuadrados;
    }

    public void setMetrosQuadrados(int metrosQuadrados) {
        this.metrosQuadrados = metrosQuadrados;
    }

    public double getDiaria() {
        return diaria;
    }

    public void setDiaria(double diaria) {
        this.diaria = diaria;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
