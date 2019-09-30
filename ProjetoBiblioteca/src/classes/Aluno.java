package classes;

public class Aluno extends Pessoa{

	private String curso;
	private String fase;
	private int matricula;

	public double mostrarTempoEmprestimo() {
		return super.mostrarTempoEmprestimo() * 1.4;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String toString() {
		return "[Nome = " + getNome() + ", Email = " + getEmail() + ", Cpf = " + getCpf() + ", curso = "
				+ curso + ", fase = " + fase + ", matricula = " + matricula + "]";
	}



}
