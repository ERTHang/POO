import java.util.ArrayList;

public class Empresa {
	private String nome;
	private Endereco endereco = new Endereco();
	private ArrayList<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
	private ArrayList<Cargo> cargos = new ArrayList<Cargo>();
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void setFuncionario(Funcionarios funcionario) {
		this.funcionarios.add(funcionario);
	}
	
	public void setCargos(Cargo cargo) {
		this.cargos.add(cargo);
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Endereco getEndereco() {
		return this.endereco;
	}
	
	public Funcionarios getFuncionario(int pos) {
		return this.funcionarios.get(pos);
	}
	
	public Cargo getCargos(int pos) {
		return this.cargos.get(pos);
	}
	
	public double mediaFunc() {
		double media = 0;
		for (Funcionarios funcionario : funcionarios) {
			media += funcionario.getCargo().getSalarioBase();
		}
		return media;
	}
	
	public ArrayList<Funcionarios> getFuncGeral() {
		return funcionarios;
	}
	
	public ArrayList<Cargo> getCargoGeral() {
		return cargos;
	}
	
}
