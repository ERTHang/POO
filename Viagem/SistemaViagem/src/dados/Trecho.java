package dados;

public class Trecho {
	private int numTrecho;
	private int duracao;
	private String dataPartida;
	private String dataChegada;
	private String horaPartida;
	private String horaChegada;
	private String classeVoo;
	private int numPoltrona=0;
	private Trecho proximoTrecho;
	private Aeroporto aeroportoOrigem = new Aeroporto();
	private Aeroporto aeroportoDestino = new Aeroporto();
	
	public void reservarPoltrona(int poltrona) {
		this.numPoltrona = poltrona;
	}
	
	public int getNumTrecho() {
		return numTrecho;
	}

	public int getDuracao() {
		return duracao;
	}

	public String getDataPartida() {
		return dataPartida;
	}

	public String getDataChegada() {
		return dataChegada;
	}

	public String getHoraPartida() {
		return horaPartida;
	}

	public String getHoraChegada() {
		return horaChegada;
	}

	public String getClasseVoo() {
		return classeVoo;
	}

	public int getNumPoltrona() {
		return numPoltrona;
	}

	public Trecho getProximoTrecho() {
		return proximoTrecho;
	}

	public Aeroporto getAeroportoOrigem() {
		return aeroportoOrigem;
	}

	public Aeroporto getAeroportoDestino() {
		return aeroportoDestino;
	}

	public void setNumTrecho(int numTrecho) {
		this.numTrecho = numTrecho;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public void setDataPartida(String dataPartida) {
		this.dataPartida = dataPartida;
	}

	public void setDataChegada(String dataChegada) {
		this.dataChegada = dataChegada;
	}

	public void setHoraPartida(String horaPartida) {
		this.horaPartida = horaPartida;
	}

	public void setHoraChegada(String horaChegada) {
		this.horaChegada = horaChegada;
	}

	public void setClasseVoo(String classeVoo) {
		this.classeVoo = classeVoo;
	}

	public void setProximoTrecho(Trecho proximoTrecho) {
		proximoTrecho = new Trecho();
		this.proximoTrecho = proximoTrecho;
	}

	public void setAeroportoOrigem(Aeroporto aeroportoOrigem) {
		this.aeroportoOrigem = aeroportoOrigem;
	}

	public void setAeroportoDestino(Aeroporto aeroportoDestino) {
		this.aeroportoDestino = aeroportoDestino;
	}

	
}
