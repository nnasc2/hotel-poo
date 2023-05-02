package entidades;

import java.sql.Date;
import java.time.LocalDate;

public class Reserva {
    private long id;
    private Date dataInicio;
    private Date dataFim;
    private Date dataCheckin;
    private Date dataCheckout;
    private long idHotel;
    private long idHospede;
    private int numQuarto;
    private double valor;

    public Reserva(){}
    public Reserva(long id, Date dataInicio, Date dataFim, long idHotel, long idHospede, int numQuarto, double valor){
        this.id = id;
        this.idHotel = idHotel;
        this.idHospede = idHospede;
        this.numQuarto = numQuarto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
    }
    public Date getDataCheckin() {
        return dataCheckin;
    }

    public void setDataCheckin(Date dataCheckin) {
        this.dataCheckin = dataCheckin;
    }

    public Date getDataCheckout() {
        return dataCheckout;
    }

    public void setDataCheckout(Date dataCheckout) {
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
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
