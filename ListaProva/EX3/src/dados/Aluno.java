package dados;

public class Aluno extends Pessoa {

	private String curso;
	private String fase;
	private int matricula;

	public String toString() {
		return "Curso = " + curso + ", Fase = " + fase + ", Matricula = " + matricula + ", Nome = " + getNome()
				+ ", Cpf = " + getCpf() + ", Email = " + getEmail();
	}

	public double mostrarTempoEmprestimo() {
		return super.mostrarTempoEmprestimo() * 1.4;
	}

	public String getCurso() {
		return curso;
	}

	public String getFase() {
		return fase;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

}
