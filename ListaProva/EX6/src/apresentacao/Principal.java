package apresentacao;

import dados.*;
import negocio.SistemaVenda;
import java.util.Scanner;

public class Principal {

	private static SistemaVenda sis = new SistemaVenda();
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		boolean sair = false;
		int opt;
		while (!sair) {
			System.out.println(
					"Menu:\n1 - Cadastrar Cliente\n2 - Cadastrar produto\n3 - Listar Cliente\n4 - Listar Produtos"
							+ "\n5 - Realizar Venda\n0 - Sair");
			opt = in.nextInt();
			in.nextLine();

			switch (opt) {
			case 1:
				try {
					cadastrarCliente();
				} catch (Exception e) {
					System.out.println("CPF já cadastrado");
				}
				break;
			case 2:
				System.out.println("1 - Cadastrar Comida\n2 - Cadastrar Bebida");
				opt = in.nextInt();
				in.nextLine();
				switch (opt) {
				case 1:
					cadastrarComida();
					break;
				case 2:
					cadastrarBebida();
					break;
				}
				break;
			case 3:
				mostrarClientes();
				break;
			case 4:
				System.out.println("1 - Listar todos os Produtos\n2 - Listar Comidas\n3 - Listar Bebidas");
				opt = in.nextInt();
				in.nextLine();
				switch (opt) {
				case 1:
					mostrarProdutos();
					break;
				case 2:
					mostrarComidas();
					break;
				case 3:
					mostrarBebidas();
					break;
				}
				break;
			case 5:
				realizarCompra();
				break;
			case 0:
				sair = false;
				break;
			default:
				break;
			}
		}

		in.close();
	}

	public static void cadastrarCliente() throws Exception {
		Cliente aux = new Cliente();

		System.out.println("CPF:");
		aux.setCpf(in.nextInt());
		in.nextLine();

		for (Cliente cliente : sis.listarClientes()) {
			if (cliente.getCpf() == aux.getCpf())
				throw new Exception();
		}

		System.out.println("Nome:");
		aux.setNome(in.nextLine());

		sis.cadastrarCliente(aux);
	}

	public static void setProduto(Produto produto) {
		System.out.println("Nome:");
		produto.setNome(in.nextLine());
		System.out.println("Preço:");
		produto.setPreco(in.nextFloat());
		in.nextLine();
	}

	public static void cadastrarBebida() {
		Bebida aux = new Bebida();

		setProduto(aux);
		System.out.println("Quantidade ML:");
		aux.setQuantidadeML(in.nextInt());
		in.nextLine();
		System.out.println("Aloolica: (1 - Sim)");
		aux.setAlcoolica(in.nextInt() == 1);
		in.nextLine();
		sis.cadastrarProduto(aux);
	}

	public static void cadastrarComida() {
		Comida aux = new Comida();

		setProduto(aux);
		System.out.println("Número Calorias:");
		aux.setNumeroCalorias(in.nextInt());
		in.nextLine();
		System.out.println("Peso:");
		aux.setPeso(in.nextInt());
		in.nextLine();

		sis.cadastrarProduto(aux);
	}

	public static void realizarCompra() {
		System.out.println("Lista de Clientes:");
		mostrarClientes();
		System.out.println();
		System.out.println("Lista de Produtos:");
		mostrarComidas();
		System.out.println();
		mostrarBebidas();

		System.out.println("Escolher CPF do cliente:");
		int aux = in.nextInt();
		in.nextLine();

		System.out.println("Escolher nome do Produto:");
		String aux2 = in.nextLine();

		for (Cliente cliente : sis.listarClientes()) {
			if (cliente.getCpf() == aux) {
				for (Produto produto : sis.listarProdutos()) {
					if (produto.getNome().equals(aux2))
						sis.realizarCompra(cliente, produto);
				}
			}
		}

	}

	public static void mostrarProdutos() {
		for (int i = 0; i < sis.listarProdutos().size(); i++)
			System.out.println(i + 1 + " - " + sis.listarProdutos().get(i).toString());
	}

	public static void mostrarComidas() {
		System.out.println("Comidas:");
		for (int i = 0; i < sis.listarProdutos().size(); i++) {
			if (sis.listarProdutos().get(i) instanceof Comida)
				System.out.println(i + 1 + ". " + sis.listarProdutos().get(i).toString());
		}
	}

	public static void mostrarBebidas() {
		System.out.println("Bebidas:");
		for (int i = 0; i < sis.listarProdutos().size(); i++) {
			if (sis.listarProdutos().get(i) instanceof Bebida)
				System.out.println(i + 1 + ". " + sis.listarProdutos().get(i).toString());
		}
	}

	public static void mostrarClientes() {
		for (int i = 0; i < sis.listarClientes().size(); i++)
			System.out.println(i + 1 + ". " + sis.listarClientes().get(i).toString());
	}

}
