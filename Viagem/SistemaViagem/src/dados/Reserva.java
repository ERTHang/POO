package dados;

import java.util.ArrayList;

public class Reserva {
	private int numReserva;
	private String dataVoo;
	private String horaVoo;
	private float preco;
	private String classeVoo;
	private boolean idaEvolta;
	private Reserva volta;
	private Cidade origem = new Cidade();
	private Cidade destino = new Cidade();
	private ArrayList<Trecho> trechos = new ArrayList<Trecho>();
	
	public void reservarTrecho(Trecho trecho) {
		trechos.add(trecho);
	}
	
	public void reservarPoltrona(Trecho trecho, int poltrona) {
		trecho.reservarPoltrona(poltrona);
		trechos.add(trecho);
	}

	public int getNumReserva() {
		return numReserva;
	}

	public void setNumReserva(int numReserva) {
		this.numReserva = numReserva;
	}

	public String getDataVoo() {
		return dataVoo;
	}

	public void setDataVoo(String dataVoo) {
		this.dataVoo = dataVoo;
	}

	public String getHoraVoo() {
		return horaVoo;
	}

	public void setHoraVoo(String horaVoo) {
		this.horaVoo = horaVoo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
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

	public Reserva getVolta() {
		return volta;
	}

	public void setVolta(Reserva volta) {
		this.volta = new Reserva();
		this.volta = volta;
	}

	public Cidade getOrigem() {
		return origem;
	}

	public void setOrigem(Cidade origem) {
		this.origem = origem;
	}

	public Cidade getDestino() {
		return destino;
	}

	public void setDestino(Cidade destino) {
		this.destino = destino;
	}
}
