package dados;

import java.sql.Date;
import java.sql.Time;

/**
 * Reserva
 */
public class Reserva {

    private int id;
    private int numreserva;
    private Date dataVoo;
    private Time horaVoo;
    private double preco;
    private String classeVoo;
    private boolean idaEvolta;
    private int idVolta;
    private int idOrigem;
    private int idDestino;
    private int idCliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumreserva() {
        return numreserva;
    }

    public void setNumreserva(int numreserva) {
        this.numreserva = numreserva;
    }

    public Date getDataVoo() {
        return dataVoo;
    }

    public void setDataVoo(Date dataVoo) {
        this.dataVoo = dataVoo;
    }

    public Time getHoraVoo() {
        return horaVoo;
    }

    public void setHoraVoo(Time horaVoo) {
        this.horaVoo = horaVoo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getClasseVoo() {
        return classeVoo;
    }

    public void setClasseVoo(String classeVoo) {
        this.classeVoo = classeVoo;
    }

    public boolean isIdaEvolta() {
        return idaEvolta;
    }

    public void setIdaEvolta(boolean idaEvolta) {
        this.idaEvolta = idaEvolta;
    }

    public int getIdVolta() {
        return idVolta;
    }

    public void setIdVolta(int idVolta) {
        this.idVolta = idVolta;
    }

    public int getIdOrigem() {
        return idOrigem;
    }

    public void setIdOrigem(int idOrigem) {
        this.idOrigem = idOrigem;
    }

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

}