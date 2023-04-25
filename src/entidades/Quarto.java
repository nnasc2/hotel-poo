package entidades;

import enums.QuartoEnum;

public class Quarto {
    private long id;
    private int numeroQuarto;
    private QuartoEnum tipoQuarto;
    private int area;
    private double diaria;
    private boolean operante;
    private boolean refeicao;
    private String descricaoCama;
    private long hotelId;
    private int ocupacaoMaxima;
    private int andar;

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public int getOcupacaoMaxima() {
        return ocupacaoMaxima;
    }

    public void setOcupacaoMaxima(int ocupacaoMaxima) {
        this.ocupacaoMaxima = ocupacaoMaxima;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricaoCama() {
        return descricaoCama;
    }

    public void setDescricaoCama(String descricaoCama) {
        this.descricaoCama = descricaoCama;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public QuartoEnum getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(QuartoEnum tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public boolean isRefeicao() {
        return refeicao;
    }

    public void setRefeicao(boolean refeicao) {
        this.refeicao = refeicao;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
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

    public boolean isOperante() {
        return operante;
    }

    public void setOperante(boolean operante) {
        this.operante = operante;
    }
}
