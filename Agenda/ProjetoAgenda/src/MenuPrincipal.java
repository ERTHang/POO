import java.util.Scanner;

public class MenuPrincipal {
	private static Agenda agenda = new Agenda();
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		boolean sair = false;
		int a;
		while(!sair) {
			System.out.println("Opcoes:\n1.Inserir contato\n2.Remover contato\n3.Consultar contato\n4.Sair");
			a = sin.nextInt();
			switch(a) {
			case 1:
				inserir();
				break;
			case 2:
				remover();
				break;
			case 3:
				consultar();
				break;
			case 4:
				sair = sair();
				break;
			}
		}
	}
	
	public static void inserir() {
		Contato aux = new Contato();
		System.out.println("Inserir contato:");
		System.out.println("Telefone:");
		long telefone = in.nextLong();
		Contato aux2 = agenda.consultaContato(telefone);
		if(aux2 == null) {
			aux.setTelefone(telefone);
			in.nextLine();
			System.out.println("Nome:");
			aux.setNome(in.nextLine());
			System.out.println("Email:");
			aux.setEmail(in.nextLine());
			System.out.println("Endereco:");
			aux.setEndereco(in.nextLine());
			
			agenda.setContato(aux);
		}
		else {
			System.out.println("Telefone ja encontrado na agenda com o nome " + aux2.getNome());
		}
		
	}
	
	public static void remover() {
		System.out.println("Remover contato:");
		System.out.println("Telefone para remover:");
		int aux = agenda.removeContato(in.nextInt());
		in.nextLine();
		if(aux == 0) {
			System.out.println("Contato nao encontrado");
		}
		else {
			System.out.println("Contato removido");
		}
		
	}
	
	public static void consultar() {
		System.out.println("Consultar contato:");
		System.out.println("Telefone do contato");
		Contato aux = agenda.consultaContato(in.nextInt());
		in.nextLine();
		if(aux == null) {
			System.out.println("Nao foi possivel encontrar o contato");
		}
		else {
			System.out.println("Contato encontrado, dados:");
			System.out.println("Nome: " + aux.getNome() + "\n" +
					"Email: " + aux.getEmail() + "\n" +
					"Endereco: " + aux.getEndereco() + "\n");
		}
	}
	
	public static boolean sair() {
		return true;
	}
}
