package app;

public class Bicicleta extends Veiculo {
    private int nMarchas;
    private int tamQuadro;
    private String tipoFreio;

    public int getnMarchas() {
        return nMarchas;
    }

    public void setnMarchas(int nMarchas) {
        this.nMarchas = nMarchas;
    }

    public int getTamQuadro() {
        return tamQuadro;
    }

    public void setTamQuadro(int tamQuadro) {
        this.tamQuadro = tamQuadro;
    }

    public String getTipoFreio() {
        return tipoFreio;
    }

    public void setTipoFreio(String tipoFreio) {
        this.tipoFreio = tipoFreio;
    }

    @Override
    public void listarVerificacoes() {
        System.out.println("Verificar na biciclieta pneu, freios, guidão e marcha");

    }

    @Override
    public void ajustar() {
        System.out.println("Todos os itens da bicicleta foram verificados com sucesso");

    }

    @Override
    public void limpar() {
        System.out.println("A bicicleta ja foi lavada e encerado");

    }

    @Override
    public String toString() {
        return "Bicicleta [nMarchas=" + nMarchas + ", tamQuadro=" + tamQuadro + ", tipoFreio=" + tipoFreio + ", marca=" + getMarca() + ", modelo=" + getModelo() + ", ano=" + getAno() + ", cor=" + getCor() + "]";
    }
    
}