package entidades;

import java.time.LocalDate;

public class Reserva {
    private long id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private LocalDate dataCheckin;
    private LocalDate dataCheckout;
    private long idHotel;
    private long idHospede;
    private int numQuarto;
    private double valor;

    public Reserva(){}
    public Reserva(long id, LocalDate dataInicio, LocalDate dataFim, long idHotel, long idHospede, int numQuarto, double valor){
        this.id = id;
        this.idHotel = idHotel;
        this.idHospede = idHospede;
        this.numQuarto = numQuarto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
    }
    public LocalDate getDataCheckin() {
        return dataCheckin;
    }

    public void setDataCheckin(LocalDate dataCheckin) {
        this.dataCheckin = dataCheckin;
    }

    public LocalDate getDataCheckout() {
        return dataCheckout;
    }

    public void setDataCheckout(LocalDate dataCheckout) {
        this.dataCheckout = dataCheckout;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public long getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(long idHospede) {
        this.idHospede = idHospede;
    }

    public void setNumero(int numero) {
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public int getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }

    public long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(long idHotel) {
        this.idHotel = idHotel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
