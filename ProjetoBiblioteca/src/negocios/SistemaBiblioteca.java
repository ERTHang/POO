package negocios;

import java.util.ArrayList;

import classes.*;

public class SistemaBiblioteca {

	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

	public ArrayList<Professor> listaProfessores() {
		ArrayList<Professor> auxProfessor = new ArrayList<Professor>();
		for (Pessoa pessoa : pessoas) {
			if (pessoa instanceof Professor) {
				auxProfessor.add((Professor) pessoa);
			}
		}
		return auxProfessor;
	}

	public ArrayList<Aluno> listaAlunos() {
		ArrayList<Aluno> auxAluno = new ArrayList<Aluno>();
		for (Pessoa pessoa : pessoas) {
			if (pessoa instanceof Aluno) {
				auxAluno.add((Aluno) pessoa);
			}
		}
		return auxAluno;
	}

	public ArrayList<Professor> listaProfessoresSalario(float salario) {
		ArrayList<Professor> auxProfessor = new ArrayList<Professor>();
		for (Pessoa pessoa : pessoas) {
			if (pessoa instanceof Professor) {
				if (((Professor) pessoa).getSalario() >= salario) {
					auxProfessor.add((Professor) pessoa);
				}
			}
		}
		return auxProfessor;
	}
	
	public void cadastraProfessor(Professor professor) {
		pessoas.add(professor);
	}
	
	public void cadastraAluno(Aluno aluno) {
		pessoas.add(aluno);
	}
	
	public void cadastraPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	
	public double mostrarTempoEmprestimo(Pessoa pessoa) {
		return pessoa.mostrarTempoEmprestimo();
	}

	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}
