import java.util.Scanner;

public class SistemaFuncionarios extends Interface {
	Scanner in = new Scanner(System.in);
	
	public void funcionarios() {
		int tamfunc;
		boolean voltar = false;
		while(true) {
			tamfunc = getSystem().getEmpresa().getFuncGeral().size();
			System.out.println("Voce possui no momento " + tamfunc + " funcionarios");
			if(tamfunc == 1) {
				System.out.println("Opcoes:\n1. Cadastrar funcionario\n2. Voltar");
				int a = in.nextInt();
				in.nextLine();
				switch(a) {
					case 1:
						System.out.println("Informacoes para cadastro de usuario:");
						getSystem().cadFuncionario();
						break;
					case 2:
						voltar = true;
						break;
					default:
						System.out.println("Comando nao reconhecido");
				}
			}
			else {
				System.out.println("Opcoes:\n1. Cadastrar funcionario\n2. Editar funcionario\n3. Mais informacoes\n4. Voltar");
				int a = in.nextInt();
				in.nextLine();
				switch(a) {
					case 1:
						System.out.println("Informacoes para cadastro de funcionarios:");
						getSystem().cadFuncionario();
						break;
					case 2:
						editarFuncionario(tamfunc);
						break;
					case 3:
						mostrarInformacoes(tamfunc);
						break;
					case 4:
						voltar = true;
						break;
					default:
						System.out.println("Comando nao reconhecido");
				}	
			}
			if(voltar) break;
		}
	}
	public void editarFuncionario(int tamfunc) {
		while(true) {
			int aux = 0;
			boolean voltar = false;
			int pos;
			System.out.println("Funcionarios cadastrados:");
			for (Funcionarios funcionario : getSystem().getEmpresa().getFuncGeral()) {
				System.out.println((aux + 1) + ". " + funcionario.getNome());
			}
			while(true) {
				System.out.println("Deseja modificar qual funcionario: (voltar = 0)");
				pos = in.nextInt() - 1;
				in.nextLine();
				if(pos > tamfunc || pos < -1) {
					System.out.println("Posicao nao encontrada");
				}
				if(pos == -1) {
					voltar = true;
				}
				break;
			}
			if(!voltar) {
				System.out.println("Modificacoes disponiveis:\n1. Nome\n2. Endereco\n3. Cargo\n4. Numero de horas extras\n5. Numero de filhos\n6. Voltar");
				int a = in.nextInt();
				in.nextLine();
				switch(a) {
					case 1:
						editarNome(pos);
						break;
					case 2:
						System.out.println("Informacoes endereco:");
						getSystem().cadEndFuncionario(pos);
						break;
					case 3:
						editarCargo(tamfunc, pos);
						break;
					case 4:
						editarHoraExtra(pos);
						break;
					case 5:
						editarNumFilhos(pos);
						break;
					case 6:
						voltar = true;
						break;
					default:
						System.out.println("Comando nao encontrado");
				}
			}
			if(voltar) break;
			
		}
	}
	
	public void mostrarInformacoes(int tamfunc) {
		int aux = 0;
		boolean voltar = false;
		int pos;
		System.out.println("Funcionarios cadastrados:");
		for (Funcionarios funcionario : getSystem().getEmpresa().getFuncGeral()) {
			System.out.println((aux + 1) + ". " + funcionario.getNome());
		}
		while(true) {
			System.out.println("Deseja a informacao de qual funcionario: (voltar = 0)");
			pos = in.nextInt() - 1;
			in.nextLine();
			if(pos > tamfunc || pos < -1) {
				System.out.println("Posicao nao encontrada");
			}
			if(pos == -1) {
				voltar = true;
			}
			break;
		}
		while(!voltar) {
			System.out.println("Opcoes:\n1. Salario liquido\n2. Salario bruto\n3. Descontos\n4. Numero de horas extras\n5. Beneficios\n6. Voltar");
			int a = in.nextInt();
			in.nextLine();
			switch(a) {
				case 1:
					getSalLiqFunc(pos);
					break;
				case 2:
					getSalBrutoFunc(pos);
					break;
				case 3:
					getDescontosFunc(pos);
					break;
				case 4:
					getHoraExtraFunc(pos);
					break;
				case 5:
					getBeneficiosFunc(pos);
					break;
				case 6:
					voltar = true;
					break;
				default:
					System.out.println("Comando nao reconhecido");
			}
		}
	}
	
	public void editarNome(int pos) {
		System.out.println("Nome:");
		getSystem().getEmpresa().getCargos(pos).setNome(in.nextLine());
	}
	
	public void editarCargo(int tamfunc, int pos) {
		int aux = 0;
		boolean voltar = false;
		int poscargo;
		System.out.println("Cargos disponiveis");
		for(Cargo cargo : getSystem().getEmpresa().getCargoGeral()) {
			System.out.println((aux + 1) + ". " + cargo.getNome());
			System.out.println(cargo.getDescricao());
		}
		while(true) {
			System.out.println("\nDeseja definir qual cargo: (0 para voltar)");
			poscargo = in.nextInt() - 1;
			in.nextLine();
			if(poscargo >= tamfunc || poscargo < -1) {
				System.out.println("Cargo nao encontrado");
			}
			else if(poscargo == -1) {
				voltar = true;
				break;
			}
			else {
				break;
			}
		}
		if(!voltar) {
			getSystem().defCargoFunc(poscargo, pos);
		}
	}
	
	public void editarHoraExtra(int pos) {
		System.out.println("Numero de horas extras registradas:");
		System.out.println(getSystem().getEmpresa().getFuncionario(pos).getNumHora());
		System.out.println("Numero de horas extras:");
		getSystem().getEmpresa().getFuncionario(pos).setNumHora(in.nextInt());;
		in.nextLine();
	}
	
	public void editarNumFilhos(int pos) {
		System.out.println("Numero de filhos registrados");
		System.out.println(getSystem().getEmpresa().getFuncionario(pos).getNumFilhos());
		System.out.println("Numero de filhos:");
		getSystem().getEmpresa().getFuncionario(pos).setNumFilhos(in.nextInt());;
		in.nextLine();
	}
	
	public void getSalLiqFunc(int pos) {
		System.out.println("Salario liquido:");
		getSystem().salLiqFunc(pos);
	}
	
	public void getSalBrutoFunc(int pos) {
		System.out.println("Salario bruto:");
		getSystem().salBrutoFunc(pos);
	}
	
	public void getDescontosFunc(int pos) {
		System.out.println("Descontos:");
		getSystem().descontosFunc(pos);
	}
	
	public void getHoraExtraFunc(int pos) {
		System.out.println("Numero de horas registradas:");
		getSystem().horaExtraFunc(pos);
	}
	
	public void getBeneficiosFunc(int pos) {
		System.out.println("Beneficios:");
		getSystem().beneficiosFunc(pos);
	}
}
