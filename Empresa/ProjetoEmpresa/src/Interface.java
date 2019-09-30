import java.util.Scanner;

public class Interface {
	Scanner in = new Scanner(System.in);
	SistemaEmpresa sisem = new SistemaEmpresa();
	
	public void user() {
		SistemaFuncionarios sisfun = new SistemaFuncionarios();
		SistemaCargos sisca = new SistemaCargos();
		System.out.println("Informacoes para cadastro de sua empresa:");
		sisem.cadEmpresa();
		sisem.cadEndEmpreso();
		System.out.println("Empresa criada com sucesso");
		while(true) {
			System.out.println("Voce deseja acessar:\n1. Cargos\n2. Funcionarios\n3. Sair");
			int a = in.nextInt();
			if(a == 1) {
				sisca.cargos();
			}
			else if(a == 2) {
				sisfun.funcionarios();
			}
			else if(a == 3) {
				System.out.println("Adeus");
				break;
			}
			else {
				System.out.println("Comando não reconhecido");
			}
		}
	}
	
	public SistemaEmpresa getSystem() {
		return sisem;
	}
}
