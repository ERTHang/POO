
public class Cargo {
	private String nome;
	private String descricao;
	private double salariobase;
	private double horaextra;
	private double valorfilho;
	
	public void setNome(String Nome) {
		nome = Nome;
	}
	
	public void setDescricao(String desc) {
		descricao = desc;
	}
	
	public void setSalarioBase(double salario) {
		salariobase = salario;
	}
	
	public void setHoraExtra(double hora) {
		horaextra = hora;
	}
	
	public void setValorFilho(double valfil) {
		valorfilho = valfil;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public double getSalarioBase() {
		return salariobase;
	}
	
	public double getHoraExtra() {
		return horaextra;
	}
	
	public double getValorFilho() {
		return valorfilho;
	}
	
	
}
