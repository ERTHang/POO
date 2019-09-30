
public class Funcionarios {
	private String nome;
	private Endereco endereco = new Endereco();
	private Cargo cargo = new Cargo();
	private int numhora;
	private int numfilhos;

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setNumHora(int hora) {
		this.numhora = hora;
	}
	
	public void setNumFilhos(int filhos) {
		this.numfilhos = filhos;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getNumHora() {
		return this.numhora;
	}
	
	public int getNumFilhos() {
		return this.numfilhos;
	}
	
	public Endereco getEndereco() {
		return this.endereco;
	}
	
	public Cargo getCargo() {
		return this.cargo;
	}
	
	public double calcAcrescimos() {
		return cargo.getValorFilho() * numfilhos + cargo.getHoraExtra() * numhora;
	}
	
	public double calcINSS() {
		return 0.11;
	}
	
	public double calcRI() {
		if(cargo.getSalarioBase() <= 1372.81) {
			return 0;
		}
		else if(cargo.getSalarioBase() >= 1372.82 && cargo.getSalarioBase() < 2743.25) {
			return 0.15;
		}
		else {
			return 0.275;
		}
	}
	
	public double calcDescontos() {
		return calcINSS() + calcRI();
	}
	
	public double salLiq() {
		return cargo.getSalarioBase() + calcAcrescimos() - calcDescontos() * cargo.getSalarioBase();
	}
	
	public double salBruto() {
		return cargo.getSalarioBase() + calcAcrescimos();
	}
	
}
