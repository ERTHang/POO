package negocios;

import java.util.ArrayList;

import dados.*;

public class SistemaBiblioteca {
	ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public ArrayList<Professor> listaProfessores() {
		ArrayList<Professor> aux = new ArrayList<Professor>();
		for (Pessoa pessoa : pessoas) {
			if (pessoa instanceof Professor) {
				aux.add((Professor) pessoa);
			}
		}
		return aux;
	}

	public ArrayList<Aluno> listaAlunos() {
		ArrayList<Aluno> aux = new ArrayList<Aluno>();
		for (Pessoa pessoa : pessoas) {
			if (pessoa instanceof Aluno) {
				aux.add((Aluno) pessoa);
			}
		}
		return aux;
	}

	public ArrayList<Professor> listaProfessoresSalario(double d) {
		ArrayList<Professor> aux = new ArrayList<Professor>();
		for (Pessoa pessoa : pessoas) {
			if (pessoa instanceof Professor) {
				if (((Professor) pessoa).getSalario() >= d) {
					aux.add((Professor) pessoa);
				}
			}
		}
		return aux;
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

}
