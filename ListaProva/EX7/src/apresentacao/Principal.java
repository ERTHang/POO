package apresentacao;

import java.util.Scanner;

import dados.*;
import negocio.ReservaPassagem;

public class Principal {
	private static Scanner in = new Scanner(System.in);
	private static ReservaPassagem res = new ReservaPassagem();
	
	public static void main(String[] args) {
		boolean sair = false;
		int opt;
		while(!sair) {
			System.out.println("\nMenu Principal");
			System.out.println("1. Cadastrar passageiro\n"
					+ "2. Cadastrar onibus\n"
					+ "3. Cadastrar viagem\n"
					+ "4. Comprar passagem\n"
					+ "5. Mostrar passagens disponíveis\n"
					+ "6. Sair");
			opt = in.nextInt();
			in.nextLine();
			switch(opt) {
			case 1:
				cadastrarPassageiro();
				break;
			case 2:
				cadastrarOnibus();
				break;
			case 3:
				cadastrarViagem();
				break;
			case 4:
				comprarPassagem();
				break;
			case 5:
				mostrarPassagemDisponivel();
				break;
			case 6:
				sair = true;
				break;
			default:
				System.out.println("Comando nao reconhecido");
			}
		}
	}

	private static void mostrarPassagemDisponivel() {
		for(Viagem viagem: res.getListaViagens()) {
			for(Assento assento : viagem.getOnibus().getAssentos()) {
				if(!assento.isOcupado()) {
					System.out.println("Viagem : " + viagem.getCodigo() + "\nAssento : " + assento.getNumero());
				}
			}
		}
	}

	private static void comprarPassagem() {
		Passageiro auxpas = new Passageiro();
		Viagem auxvia = new Viagem();
		System.out.println("Qual passageiro? (0 para cadastrar um novo)");
		res.listarPassageiros();
		int opt = in.nextInt();
		in.nextLine();
		if(opt == 0) {
			cadastrarPassageiro();
			auxpas = res.ultimoPassageiro();
		}
		else {
			auxpas = res.getListaPassageiros().get(opt - 1);
		}
		System.out.println("Qual Viagem? (0 para cadastrar uma nova)");
		res.listarViagens();
		opt = in.nextInt();
		in.nextLine();
		if(opt == 0) {
			cadastrarViagem();
			auxvia = res.ultimaViagem();
		}
		else {
			auxvia = res.getListaViagens().get(opt - 1);
		}
		while(true) {
			System.out.println("\nAssento:");
			int auxassento = in.nextInt();
			in.nextLine();
			if(res.reservarIda(auxpas, auxvia, auxassento)) {
				break;
			}
			
		}
		
	}
	
	private static void cadastrarCidade() {
		Cidade aux = new Cidade();
		System.out.println("Nome:");
		aux.setNome(in.nextLine());
		System.out.println("Codigo");
		aux.setCodigoCidade(in.nextInt());
		in.nextLine();
		
		res.cadastrarCidade(aux);
	}

	private static void cadastrarViagem() {
		Viagem aux = new Viagem();
		int opt;
		System.out.println("Onibus: (0 para cadastrar um novo)");
		res.listarOnibus();
		opt = in.nextInt();
		in.nextLine();
		if(opt == 0) {
			cadastrarOnibus();
			aux.setOnibus(res.ultimoOnibus());
		}
		else {
			aux.setOnibus(res.getListaOnibus().get(opt - 1));
		}
		System.out.println("Cidade origem: (0 para cadastrar um novo)");
		res.listarCidades();
		opt = in.nextInt();
		in.nextLine();
		if(opt == 0) {
			cadastrarCidade();
			aux.setOrigem(res.ultimaCidade());
		}
		else {
			aux.setOrigem(res.getListaCidade().get(opt - 1));
		}
		System.out.println("Cidade destino: (0 para cadastrar um novo)");
		res.listarCidades();
		opt = in.nextInt();
		in.nextLine();
		if(opt == 0) {
			cadastrarCidade();
			aux.setOrigem(res.ultimaCidade());
		}
		else {
			aux.setOrigem(res.getListaCidade().get(opt - 1));
		}
		System.out.println("Codigo:");
		aux.setCodigo(in.nextInt());
		in.nextLine();
		System.out.println("Preco:");
		aux.setPreco(in.nextFloat());
		in.nextLine();
		
		res.cadastrarViagem(aux);
		
	}

	private static void cadastrarOnibus() {
		Onibus aux = new Onibus();
		System.out.println("Codigo");
		aux.setCodigo(in.nextInt());
		in.nextLine();
		System.out.println("Numero de assentos:");
		aux.setNumeroAssentos(in.nextInt());
		in.nextLine();
		System.out.println("Ar Condicionado? (sim ou  nao)");
		aux.setArCondicionado(in.nextLine() == "sim");
		
		res.cadastrarOnibus(aux);
	}

	private static void cadastrarPassageiro() {
		Passageiro aux = new Passageiro();
		System.out.println("Nome:");
		aux.setNome(in.nextLine());
		System.out.println("Cpf:");
		aux.setCpf(in.nextInt());
		in.nextLine();
		System.out.println("RG:");
		aux.setRg(in.nextInt());
		in.nextLine();
		System.out.println("Endereco:");
		aux.setEndereco(in.nextLine());
		
		res.cadastrarPassageiro(aux);	
	}
}
