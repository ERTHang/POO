package dados;

public class Pessoa {
	private String nome;
	private int cpf;
	private String email;
	private double tempoEmprestimo;
	
	public double mostrarTempoEmprestimo() {
		return this.tempoEmprestimo;
	}
	public String getNome() {
		return nome;
	}

	public int getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTempoEmprestimo(int tempoEmprestimo) {
		this.tempoEmprestimo = tempoEmprestimo;
	}

}
