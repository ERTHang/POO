package classes;

public class Professor extends Pessoa {

	private String formacao;
	private float salario;
	private String departamento;

	public double mostrarTempoEmprestimo() {
		return super.mostrarTempoEmprestimo() * 1.7;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String toString() {
		return "[ Nome = " + getNome() + ", CPF = " + getCpf() + ", Email = " + getEmail() + "Tempo de Emprestimo = "
				+ mostrarTempoEmprestimo() + "\nFormacao = " + formacao + ", Salario = " + salario + ", Departamento = "
				+ departamento + "]";
	}

}
