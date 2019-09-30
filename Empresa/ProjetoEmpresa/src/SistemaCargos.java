import java.util.Scanner;

public class SistemaCargos extends Interface {
	Scanner in = new Scanner(System.in);
	
	public void cargos() {
		int tamcargo;
		boolean voltar = false;
		while(true) {
			tamcargo = getSystem().getEmpresa().getCargoGeral().size();
			System.out.println("Voce possui no momento " + tamcargo + " cargos");
			if(tamcargo == 0) {
				System.out.println("Opcoes:\n1. Criar cargo\n2. Voltar");
				int a = in.nextInt();
				in.nextLine();
				switch(a) {
					case 1:
						System.out.println("Informacoes para cadastro de cargo:");
						getSystem().cadCargos();
						break;
					case 2:
						voltar = true;
						break;
					default:
						System.out.println("Comando nao reconhecido");
				}
			}
			else {
				System.out.println("Opcoes:\n1. Criar cargo\n2. Editar Cargos\n3. Voltar");
				int a = in.nextInt();
				in.nextLine();
				switch(a) {
					case 1:
						System.out.println("Informacoes para cadastro de cargo:");
						getSystem().cadCargos();
						break;
					case 2:
						editarCargos(tamcargo);
						voltar = true;
						break;
					case 3:
						voltar = true;
						break;
					default:
						System.out.println("Comando nao reconhecido");
					
				}
			}
			if(voltar) {
				break;
			}
		}
	}
	
	public void editarCargos(int tamcargo) {
		while(true){
			int aux = 0;
			boolean voltar = false;
			int pos;
			System.out.println("Cargos cadastrados:");
			for (Cargo cargo : getSystem().getEmpresa().getCargoGeral()) {
				System.out.println((aux + 1) + ". " + cargo.getNome());
			}
			while(true) {
				System.out.println("Deseja modificar qual cargo: (Voltar = 0)");
				pos = in.nextInt() - 1;
				in.nextLine();
				if (pos >= tamcargo || pos < -1) {
					System.out.println("posicao nao encontrada");
				}
				if(pos == -1) {
					voltar = true;
				}
				else break;
			}
			if(!voltar) {
				System.out.println("Modificacoes disponiveis:\n1. Nome\n2. Descricao\n3. Salario base\n4. Valor por hora extra\n5. Valor por filho\n6. Voltar");
				int a = in.nextInt();
				in.nextLine();
				switch(a) {
					case 1:
						editarNome(pos);
						break;
					case 2:
						editarDescricao(pos);
						break;
					case 3:
						editarSalario(pos);
						break;
					case 4:
						editarValorExtra(pos);
						break;
					case 5:
						editarValorFilho(pos);
						break;
					case 6:
						voltar = true;
						break;
					default:
						System.out.println("Comando nao reconhecido");
				}
			}
			if(voltar) {
				break;
			}
		}
	}
	
	public void editarNome(int pos) {
		System.out.println("Nome:");
		getSystem().getEmpresa().getCargos(pos).setNome(in.nextLine());
	}
	
	public void editarDescricao(int pos) {
		System.out.println("Descricao cadastrada:");
		System.out.println(getSystem().getEmpresa().getCargos(pos).getDescricao());
		System.out.println("Descricao:");
		getSystem().getEmpresa().getCargos(pos).setDescricao(in.nextLine());
		
	}
	
	public void editarSalario(int pos) {
		System.out.println("Salario cadastrado:");
		System.out.println(getSystem().getEmpresa().getCargos(pos).getSalarioBase());
		System.out.println("Salario:");
		getSystem().getEmpresa().getCargos(pos).setSalarioBase(in.nextDouble());
		in.nextLine();
	}
	
	public void editarValorFilho(int pos) {
		System.out.println("Valor por filho cadastrado:");
		System.out.println(getSystem().getEmpresa().getCargos(pos).getValorFilho());
		System.out.println("Valor por filho:");
		getSystem().getEmpresa().getCargos(pos).setValorFilho(in.nextDouble());
		in.nextLine();
	}
	
	public void editarValorExtra(int pos) {
		System.out.println("Valor por hora extra cadastrado:");
		System.out.println(getSystem().getEmpresa().getCargos(pos).getHoraExtra());
		System.out.println("Valor por hora extra:");
		getSystem().getEmpresa().getCargos(pos).setHoraExtra(in.nextDouble());
		in.nextLine();
	}
	
}
