package app;

public abstract class Veiculo {
    private String marca;
    private int modelo;
    private int ano;
    private String cor;

    public abstract void listarVerificacoes();

    public abstract void ajustar();

    public abstract void limpar();

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Veiculo [ano=" + ano + ", cor=" + cor + ", marca=" + marca + ", modelo=" + modelo + "]";
    }

}