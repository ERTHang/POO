package dados;

public class Viagem {

	private Onibus onibus;
	private Cidade origem = new Cidade();
	private Cidade destino = new Cidade();
	private Viagem volta;
	private int codigo;
	private boolean idaVolta;
	private float preco;

	public Viagem() {
		this.volta = null;
		this.idaVolta = false;
	}

	public Onibus getOnibus() {
		return onibus;
	}

	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
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

	public Viagem getVolta() {
		return volta;
	}

	public void setVolta(Viagem volta) {
		this.idaVolta = true;
		this.volta = new Viagem();
		this.volta = volta;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public boolean isIdaVolta() {
		return idaVolta;
	}

	public void setIdaVolta(boolean idaVolta) {
		this.idaVolta = idaVolta;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

}
