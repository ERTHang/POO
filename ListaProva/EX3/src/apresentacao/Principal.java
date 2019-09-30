package apresentacao;

import java.util.Scanner;

import dados.*;
import negocios.SistemaBiblioteca;

public class Principal {
	private static SistemaBiblioteca sis = new SistemaBiblioteca();
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean sair = false;
		int opt;
		while(!sair) {
			System.out.println("\nMenu Principal");
			System.out.println("1. Professores\n"
					+ "2. Alunos\n"
					+ "3. Cadastrar pessoa\n"
					+ "4. Tempo de emprestimo\n"
					+ "5. Sair");
			opt = in.nextInt();
			in.nextLine();
			switch(opt) {
			case 1:
				System.out.println("1. Todos\n"
						+ "2. Com comparacao de salario\n"
						+ "3. Cadastrar");
				opt = in.nextInt();
				in.nextLine();
				switch(opt) {
				case 1:
					mostrarProfessores();
					break;
				case 2:
					mostrarProfessoresSalario();
					break;
				case 3:
					cadastrarProfessor();
					break;
				default:
					System.out.println("Comando nao reconhecido");
					break;
				}
				break;
			case 2:
				System.out.println("1. Mostrar alunos\n"
						+ "2. Cadastrar alunos");
				opt = in.nextInt();
				in.nextLine();
				switch(opt) {
				case 1:
					mostrarAlunos();
					break;
				case 2:
					cadastrarAluno();
					break;
				default:
					System.out.println("Comando nao reconhecido");
					break;
				}
				break;
			case 3:
				cadastraPessoa();
				break;
			case 4:
				tempoEmprestimo();
				break;
			case 5:
				sair = true;
				break;
			}
			
		}
	}

	private static void tempoEmprestimo() {
		System.out.println("CPF que deseja ver o tempo");
		int cpf = in.nextInt();
		in.nextLine();
		for(Pessoa pessoa: sis.getPessoas()) {
			if(pessoa.getCpf() == cpf){
				System.out.println("Tempo da pessoa requerida = " + pessoa.mostrarTempoEmprestimo());
			}
		}
	}

	private static void cadastraPessoa() {
		Pessoa aux = new Pessoa();
		System.out.println("Nome:");
		aux.setNome(in.nextLine());
		System.out.println("CPF:");
		aux.setCpf(in.nextInt());
		in.nextLine();
		System.out.println("Email:");
		aux.setEmail(in.nextLine());
		System.out.println("Tempo de emprestimo:");
		aux.setTempoEmprestimo(in.nextInt());
		in.nextLine();
		sis.cadastraPessoa(aux);
	}

	private static void cadastrarAluno() {
		Aluno aux = new Aluno();
		System.out.println("Nome:");
		aux.setNome(in.nextLine());
		System.out.println("CPF:");
		aux.setCpf(in.nextInt());
		in.nextLine();
		System.out.println("Email:");
		aux.setEmail(in.nextLine());
		System.out.println("Tempo de emprestimo:");
		aux.setTempoEmprestimo(in.nextInt());
		in.nextLine();
		System.out.println("Curso:");
		aux.setCurso(in.nextLine());
		System.out.println("Fase:");
		aux.setFase(in.nextLine());
		System.out.println("Matricula:");
		aux.setMatricula(in.nextInt());
		in.nextLine();
		
		sis.cadastraAluno(aux);
		
	}

	private static void mostrarAlunos() {
		for(Aluno aluno: sis.listaAlunos()) {
			System.out.println(aluno.toString());
		}
		
	}

	private static void cadastrarProfessor() {
		Professor aux = new Professor();
		System.out.println("Nome:");
		aux.setNome(in.nextLine());
		System.out.println("CPF:");
		aux.setCpf(in.nextInt());
		in.nextLine();
		System.out.println("Email:");
		aux.setEmail(in.nextLine());
		System.out.println("Tempo de emprestimo:");
		aux.setTempoEmprestimo(in.nextInt());
		in.nextLine();
		System.out.println("Formacao:");
		aux.setFormacao(in.nextLine());
		System.out.println("Salario:");
		aux.setSalario(in.nextFloat());
		in.nextLine();
		System.out.println("Departamento:");
		aux.setDepartamento(in.nextLine());
		
		sis.cadastraProfessor(aux);
		
	}

	private static void mostrarProfessoresSalario() {
		System.out.println("Salario maior ou igual a");
		for(Professor professor : sis.listaProfessoresSalario(in.nextDouble())) {
			System.out.println(professor.toString());
		}
		in.nextLine();
		
	}

	private static void mostrarProfessores() {
		for(Professor professor : sis.listaProfessores()) {
			System.out.println(professor.toString());
		}
	}
}
