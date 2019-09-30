package app;

public class Automovel extends Veiculo {
    private String combustivel;
    private int potencia;
    private int nPortas;

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getNportas() {
        return nPortas;
    }

    public void setNportas(int nportas) {
        this.nPortas = nportas;
    }

    public void trocarOleo() {
        System.out.println("O oleo foi trocado com sucesso");
    }

    @Override
    public void listarVerificacoes() {
        System.out.println("Verificar no automovel pneu, suspensao e motor");

    }

    @Override
    public void ajustar() {
        System.out.println("Todos os itens do automovel foram verificados com sucesso");

    }

    @Override
    public void limpar() {
        System.out.println("O automovel ja foi lavado e encerado");

    }

    @Override
    public String toString() {
        return "Automovel [combustivel=" + combustivel + ", nPortas=" + nPortas + ", potencia=" + potencia + ", marca=" + getMarca() + ", modelo=" + getModelo() + ", ano=" + getAno() + ", cor=" + getCor() + "]";
    }
}