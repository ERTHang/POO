package dados;

public class Professor extends Pessoa{

	private String formacao;
	private float salario;
	private String departamento;
	
	public String toString() {
		return "Formacao = " + formacao + ", Salario = " + salario + ", Departamento = " + departamento + ", Nome = " + getNome()
				+ ", Cpf = " + getCpf() + ", Email = " + getEmail();
				}
	
	public double mostrarTempoEmprestimo() {
		return super.mostrarTempoEmprestimo() * 1.7;
	}

	public String getFormacao() {
		return formacao;
	}

	public float getSalario() {
		return salario;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

}
