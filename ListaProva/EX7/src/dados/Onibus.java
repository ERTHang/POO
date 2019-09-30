package dados;

import java.util.ArrayList;

public class Onibus {

	private ArrayList<Assento> assentos = new ArrayList<Assento>();
	private int numeroAssentos;
	private boolean arCondicionado;
	private int codigo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public ArrayList<Assento> getAssentos() {
		return assentos;
	}

	public void setAssentos(ArrayList<Assento> assentos) {
		this.assentos = assentos;
	}

	public int getNumeroAssentos() {
		return numeroAssentos;
	}

	public void setNumeroAssentos(int numeroAssentos) {
		this.numeroAssentos = numeroAssentos;

		for (int i = 0; i < numeroAssentos; i++) {
			Assento aux = new Assento();
			aux.setNumero(i + 1);

			assentos.add(aux);
		}
	}

	public boolean isArCondicionado() {
		return arCondicionado;
	}

	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}

}
