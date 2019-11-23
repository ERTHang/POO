package dados;

import java.sql.Date;
import java.sql.Time;

/**
 * Trecho
 */
public class Trecho {
    private int id;
    private int numtrecho;
    private int duracao;
    private Date datapartida;
    private Date datachegada;
    private Time horapartida;
    private Time horachegada;
    private String classevoo;
    private int numpoltrona;
    private int idproximotrecho;
    private int idaeroorigem;
    private int idaerodestino;
    private int idreserva;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumtrecho() {
        return numtrecho;
    }

    public void setNumtrecho(int numtrecho) {
        this.numtrecho = numtrecho;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Date getDatapartida() {
        return datapartida;
    }

    public void setDatapartida(Date datapartida) {
        this.datapartida = datapartida;
    }

    public Date getDatachegada() {
        return datachegada;
    }

    public void setDatachegada(Date datachegada) {
        this.datachegada = datachegada;
    }

    public Time getHorapartida() {
        return horapartida;
    }

    public void setHorapartida(Time horapartida) {
        this.horapartida = horapartida;
    }

    public Time getHorachegada() {
        return horachegada;
    }

    public void setHorachegada(Time horachegada) {
        this.horachegada = horachegada;
    }

    public String getClassevoo() {
        return classevoo;
    }

    public void setClassevoo(String classevoo) {
        this.classevoo = classevoo;
    }

    public int getNumpoltrona() {
        return numpoltrona;
    }

    public void setNumpoltrona(int numpoltrona) {
        this.numpoltrona = numpoltrona;
    }

    public int getIdproximotrecho() {
        return idproximotrecho;
    }

    public void setIdproximotrecho(int idproximotrecho) {
        this.idproximotrecho = idproximotrecho;
    }

    public int getIdaeroorigem() {
        return idaeroorigem;
    }

    public void setIdaeroorigem(int idaeroorigem) {
        this.idaeroorigem = idaeroorigem;
    }

    public int getIdaerodestino() {
        return idaerodestino;
    }

    public void setIdaerodestino(int idaerodestino) {
        this.idaerodestino = idaerodestino;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

}