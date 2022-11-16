package entidades;

import java.time.LocalDate;

public class Reserva {
    private long id;

    private long numero;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private long idHotel;
    private long idHospede;

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public long getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(long idHospede) {
        this.idHospede = idHospede;
    }

    private int numQuarto;

    public long getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
