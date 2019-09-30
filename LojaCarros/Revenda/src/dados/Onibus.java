package dados;

public class Onibus extends Veiculo {
	private int numAssentos;
	private int poteciaCav;

	public int getNumAssentos() {
		return numAssentos;
	}

	public int getPoteciaCav() {
		return poteciaCav;
	}

	public void setNumAssentos(int numAssentos) {
		this.numAssentos = numAssentos;
	}

	public void setPoteciaCav(int poteciaCav) {
		this.poteciaCav = poteciaCav;
	}
}