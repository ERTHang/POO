package apresentacao;

import dados.*;

import java.util.Scanner;

import logica.Revenda;

public class Sistema {

	private static Revenda revenda = new Revenda(50);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean sair = false;
		int opcao;

		while (!sair) {
			System.out.println("\nSistema de Revenda");
			System.out.println("1 - Cadastrar Veiculo");
			System.out.println("2 - Listar veiculos");
			System.out.println("3 - Mostrar detalhes do veiculo");
			System.out.println("4 - Vender veiculo");
			System.out.println("0 - Para sair");
			System.out.print("Digite a opcao desejada:");
			opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
			case 0:
				sair = true;
				break;
			case 1:
				cadastrarVeiculo();
				break;
			case 2:
				listarVeiculo();
				break;
			case 3:
				System.out.println("Numero da placa:");
				mostrarDetalhesVeivulo(sc.nextLine());
				break;
			case 4:
				System.out.println("Numero da placa:");
				venderVeiculo(sc.nextLine());
				break;
			default:
				break;
			}
		}

	}

	private static void venderVeiculo(String placa) {
		Scanner in = new Scanner(System.in);
		Veiculo[] aux = revenda.getVeiculoNaoVendidos();

		for (Veiculo veiculo : aux) {
			if (veiculo.getNumPlaca().equals(placa)) {
				System.out.println("Data de venda:");
				veiculo.setDataVenda(in.nextLine());
				revenda.vendaVeiculo(veiculo);
				break;
			}
		}
	}

	private static void mostrarDetalhesVeivulo(String placa) {
		Veiculo[] aux = revenda.getVeiculos();
		for (Veiculo veiculo : aux) {
			if (veiculo.getNumPlaca().equals(placa)) {
				if (veiculo instanceof Carro) {
					System.out.println(String.format(
							"O veiculo e um carro\nNumero de assentos: %d\nPotencia em CV: %d Cavalos\nNumero de Portas: %d",
							((Carro) veiculo).getNumAssentos(), ((Carro) veiculo).getPotenciaCV(),
							((Carro) veiculo).getNumPortas()));
				} else if (veiculo instanceof Caminhao) {
					System.out.println(String.format(
							"O veiculo e um caminhao\nCapacidade Maxima: %.2f KG\nTipo de Carroceria: %s\nPotencia em CV: %d Cavalos\nNumero de Eixos: %d",
							((Caminhao) veiculo).getCapacidadeMaxima(), ((Caminhao) veiculo).getTipoCarroceria(),
							((Caminhao) veiculo).getPotenciaCV(), ((Caminhao) veiculo).getNumEixos()));
				} else if (veiculo instanceof Moto) {
					System.out.println(
							String.format("O veiculo e uma moto\nCilindradas: %d", ((Moto) veiculo).getCilindradas()));
				} else if (veiculo instanceof Onibus) {
					System.out.println(
							String.format("O veiculo e um onibus\nNumero de Assentos: %d\nPotencia em CV: %d Cavalos",
									((Onibus) veiculo).getNumAssentos(), ((Onibus) veiculo).getPoteciaCav()));
				} else if (veiculo instanceof Caminhonete) {
					System.out.println(String.format(
							"O veiculo e uma caminhonete\nCapacidade de Carga: %d\nTipo de Carroceria: %s\nPotencia em Cavalos: %d Cavalos\nVeiculo%stem cabine dupla"
									+ "Numero de assentos: %d\nNumero de Portas: %d",
							((Caminhonete) veiculo).getCapCarga(), ((Caminhonete) veiculo).getTipoCarroceria(),
							((Caminhonete) veiculo).getPotenciaCV(),
							(((Caminhonete) veiculo).isCabineDupla()) ? " " : " nao ",
							((Caminhonete) veiculo).getNumAssentos(), ((Caminhonete) veiculo).getNumPortas()));
				}
				System.out.printf(
						"Ano de Fabricacao: %d\n" + "Modelo: %s\n" + "Cor: %s\n" + "Numero do Chassi: %s\n"
								+ "Quilometragem: %.2f KM\n" + "Marca: %s\n" + "Numero de Marchas: %d\n"
								+ "Valor do veiculo: R$ %.2f\n" + "Data da Entrada: %s\n",
						veiculo.getAnoFabricacao(), veiculo.getModelo(), veiculo.getCor(), veiculo.getNumChassi(),
						veiculo.getQuilometragem(), veiculo.getMarca(), veiculo.getNumMarchas(),
						veiculo.getValorVeiculo(), veiculo.getDataEntrada(), veiculo.getDataVenda());
				if (veiculo.isVendido()) {
					System.out.println("VEICULO VENDIDO\nData de venda: " + veiculo.getDataVenda());
				} else {
					System.out.println("VEICULO NAO VENDIDO.");
				}
				return;
			}
		}
	}

	private static void listarVeiculo() {
		Veiculo[] aux = revenda.getVeiculoNaoVendidos();
		for (int i = 0; i < aux.length; i++) {
			if (aux[i] instanceof Carro) {
				System.out.println(String.format("%d . Carro\nPLACA: %s\nMARCA: %s\nANO: %d\n", i, aux[i].getNumPlaca(),
						aux[i].getMarca(), aux[i].getAnoFabricacao()));
			} else if (aux[i] instanceof Caminhao) {
				System.out.println(String.format("%d . Caminhao\nPLACA: %s\nMARCA: %s\nANO: %d\n", i,
						aux[i].getNumPlaca(), aux[i].getMarca(), aux[i].getAnoFabricacao()));
			} else if (aux[i] instanceof Moto) {
				System.out.println(String.format("%d . Moto\nPLACA: %s\nMARCA: %s\nANO: %d\n", i, aux[i].getNumPlaca(),
						aux[i].getMarca(), aux[i].getAnoFabricacao()));
			} else if (aux[i] instanceof Onibus) {
				System.out.println(String.format("%d . Onibus\nPLACA: %s\nMARCA: %s\nANO: %d\n", i,
						aux[i].getNumPlaca(), aux[i].getMarca(), aux[i].getAnoFabricacao()));
			} else if (aux[i] instanceof Caminhonete) {
				System.out.println(String.format("%d . Caminhonete\nPLACA: %s\nMARCA: %s\nANO: %d\n", i,
						aux[i].getNumPlaca(), aux[i].getMarca(), aux[i].getAnoFabricacao()));
			}
		}

	}

	private static void cadastrarVeiculo() {
		Scanner sc = new Scanner(System.in);
		int tipo = 0;

		System.out.println("1 - Carro");
		System.out.println("2 - Caminhao");
		System.out.println("3 - Onibus");
		System.out.println("4 - Caminhonete");
		System.out.println("5 - Moto");
		System.out.println("Informe o tipo do veiculo:");
		tipo = sc.nextInt();
		switch (tipo) {
		case 1:
			Carro carro = new Carro();
			recebeVeiculo(carro, tipo);
			break;
		case 2:
			Caminhao caminhao = new Caminhao();
			recebeVeiculo(caminhao, tipo);
			break;
		case 3:
			Onibus onibus = new Onibus();
			recebeVeiculo(onibus, tipo);
			break;
		case 4:
			Caminhonete caminhonete = new Caminhonete();
			recebeVeiculo(caminhonete, tipo);
			break;
		case 5:
			Moto moto = new Moto();
			recebeVeiculo(moto, tipo);
			break;
		default:
			System.out.println("Veiculo nao reconhecido");
			break;
		}
	}

	private static void recebeVeiculo(Veiculo veiculo, int tipo) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Marca:");
		veiculo.setMarca(sc.nextLine());
		System.out.println("Modelo:");
		veiculo.setModelo(sc.nextLine());
		System.out.println("Ano de fabricacao:");
		veiculo.setAnoFabricacao(sc.nextInt());
		sc.nextLine();
		System.out.println("Numero da placa:");
		veiculo.setNumPlaca(sc.nextLine());
		System.out.println("Cor:");
		veiculo.setCor(sc.nextLine());
		System.out.println("Numero de chassi:");
		veiculo.setNumChassi(sc.nextLine());
		System.out.println("Quilometragem:");
		veiculo.setQuilometragem(sc.nextInt());
		sc.nextLine();
		System.out.println("Numero de marchas:");
		veiculo.setNumMarchas(sc.nextInt());
		sc.nextLine();
		System.out.println("Valor:");
		veiculo.setValorVeiculo(sc.nextInt());
		sc.nextLine();
		System.out.println("Data de entrada veiculo");
		veiculo.setDataEntrada(sc.nextLine());
		veiculo.setVendido(false);
		switch (tipo) {
		case 1:
			recebeCarro((Carro) veiculo);
			break;
		case 2:
			recebeCaminhao((Caminhao) veiculo);
			break;
		case 3:
			recebeOnibus((Onibus) veiculo);
			break;
		case 4:
			recebeCaminhonete((Caminhonete) veiculo);
			break;
		case 5:
			recebeMoto((Moto) veiculo);
			break;

		}

		revenda.cadastraVeiculo(veiculo);
	}

	public static void recebeCarro(Carro veiculo) {
		Scanner in = new Scanner(System.in);
		System.out.println("Numero de assentos");
		veiculo.setNumAssentos(in.nextInt());
		in.nextLine();
		System.out.println("Potencia em CV:");
		veiculo.setPotenciaCV(in.nextInt());
		in.nextLine();
		System.out.println("Numero de portas:");
		veiculo.setNumPortas(in.nextInt());
		in.nextLine();

	}

	public static void recebeCaminhao(Caminhao veiculo) {
		Scanner in = new Scanner(System.in);
		System.out.println("Capacidade maxima:");
		veiculo.setCapacidadeMaxima(in.nextInt());
		in.nextLine();
		System.out.println("Tipo de carroceria:");
		veiculo.setTipoCarroceria(in.nextLine());
		System.out.println("Potencia em CV");
		veiculo.setPotenciaCV(in.nextInt());
		in.nextLine();
		System.out.println("Numero de eixos");
		veiculo.setNumEixos(in.nextInt());
		in.nextLine();
	}

	public static void recebeOnibus(Onibus veiculo) {
		Scanner in = new Scanner(System.in);
		System.out.println("Numero de Assentos:");
		veiculo.setNumAssentos(in.nextInt());
		in.nextLine();
		System.out.println("Potencia em CV:");
		veiculo.setPoteciaCav(in.nextInt());
		in.nextLine();
	}

	private static void recebeCaminhonete(Caminhonete veiculo) {
		Scanner in = new Scanner(System.in);
		System.out.println("Capacidade de Carga:");
		veiculo.setCapCarga(in.nextInt());
		in.nextLine();
		System.out.println("Tipo de Carroceria:");
		veiculo.setTipoCarroceria(in.nextLine());
		System.out.println("Potencia em Cavalos:");
		veiculo.setPotenciaCV(in.nextInt());
		in.nextLine();
		System.out.println("Cabine Dupla:");
		veiculo.setCabineDupla(in.nextLine() == "sim");
		System.out.println("Numero de assentos:");
		veiculo.setNumAssentos(in.nextInt());
		in.nextLine();
		System.out.println("Numero de portas:");
		veiculo.setNumPortas(in.nextInt());
		in.nextLine();
	}

	private static void recebeMoto(Moto veiculo) {
		Scanner in = new Scanner(System.in);
		System.out.println("Cilindradas:");
		veiculo.setCilindradas(in.nextInt());
		in.nextLine();
	}

}
