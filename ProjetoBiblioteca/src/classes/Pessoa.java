package classes;

public class Pessoa {

	private String Nome;
	private int cpf;
	private String email;
	private int tempoEmprestimo;

	public double mostrarTempoEmprestimo() {
		return getTempoEmprestimo();
	}


	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTempoEmprestimo() {
		return tempoEmprestimo;
	}

	public void setTempoEmprestimo(int tempoEmprestimo) {
		this.tempoEmprestimo = tempoEmprestimo;
	}

	@Override
	public String toString() {
		return "[Nome = " + Nome + ", cpf = " + cpf + ", email = " + email + "]";
	}
}
