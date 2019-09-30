package dados;

public class Caminhonete extends Veiculo {
	private int capCarga;
	private String tipoCarroceria;
	private boolean cabineDupla;
	private int numAssentos;
	private int potenciaCV;
	private int numPortas;

	public int getCapCarga() {
		return capCarga;
	}

	public String getTipoCarroceria() {
		return tipoCarroceria;
	}

	public boolean isCabineDupla() {
		return cabineDupla;
	}

	public int getNumAssentos() {
		return numAssentos;
	}

	public int getPotenciaCV() {
		return potenciaCV;
	}

	public int getNumPortas() {
		return numPortas;
	}

	public void setCapCarga(int capCarga) {
		this.capCarga = capCarga;
	}

	public void setTipoCarroceria(String tipoCarroceria) {
		this.tipoCarroceria = tipoCarroceria;
	}

	public void setCabineDupla(boolean cabineDupla) {
		this.cabineDupla = cabineDupla;
	}

	public void setNumAssentos(int numAssentos) {
		this.numAssentos = numAssentos;
	}

	public void setPotenciaCV(int potenciaCV) {
		this.potenciaCV = potenciaCV;
	}

	public void setNumPortas(int numPortas) {
		this.numPortas = numPortas;
	}

}