package dados;

public class NotaFiscal {
    private int id;
    private int numProtocolo;
    private String cnpj;
    private double valor;
    private int idPJ;
    private int idContribuinte;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumProtocolo() {
        return numProtocolo;
    }

    public void setNumProtocolo(int numProtocolo) {
        this.numProtocolo = numProtocolo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getIdPJ() {
        return idPJ;
    }

    public void setIdPJ(int idPJ) {
        this.idPJ = idPJ;
    }

    public int getIdContribuinte() {
        return idContribuinte;
    }

    public void setIdContribuinte(int idContribuinte) {
        this.idContribuinte = idContribuinte;
    }

}