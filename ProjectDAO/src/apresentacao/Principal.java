package apresentacao;
import dados.*;
import negocio.*;
import java.util.Scanner;

public class Principal {
	private static ReservaPassagem reservaPassagem = new ReservaPassagem();
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean sair=false;
		while(!sair) {
			System.out.println("Opcoes:\n1.Fazer reserva\n2.Cadastrar cliente\n3.Cadastrar cidade\n4.Cadastrar aeroporto\n5.Mostrar reservas\n6.Sair\n");
			int a = in.nextInt();
			in.nextLine();
			switch(a) {
				case 1:
					fazerReserva();
					break;
				case 2:
					cadastrarCliente();
					break;
				case 3:
					cadastrarCidade();
					break;					
				case 4:
					cadastrarAeroporto();
					break;					
				case 5:
					mostrarReservas();
					break;					
				case 6:
					sair = true;
					break;
				default:
					System.out.println("Comando nao reconhecido");
					break;
			}
		}
	}
	
	public static void fazerReserva() {
		System.out.println("Reserva:");
		System.out.println("Opcoes:\n"
				+ "1.Reserva simples\n"
				+ "2.Ida e volta\n"
				+ "3.Trecho especifico\n"
				+ "4.Poltrona especifica\n");
		int a = in.nextInt();
		in.nextLine();
		switch(a) {
			case 1:
				reservaPassagem.reservarIda(receberCliente(), receberReserva());
				break;
			case 2:
				reservaPassagem.reservarVolta(receberCliente(), receberReserva(), receberReservaVolta());
				break;
			case 3:
				reservaPassagem.reservarTrecho(receberCliente(), receberReserva(), receberTrecho());
				break;
			case 4:
				reservaPassagem.reservarPoltrona(receberCliente(), receberReserva(), receberTrecho(), receberPoltrona());
				break;
			default:
				System.out.println("Comando nao encontrado");
		}
	}

	
	public static void cadastrarCliente() {
		reservaPassagem.cadastrarCliente(receberCliente());
	}
	
	public static void cadastrarCidade() {
		reservaPassagem.cadastrarCidade(receberCidade());
	}
	
	public static void cadastrarAeroporto() {
		reservaPassagem.cadastrarAeroporto(receberAeroporto());
	}
	
	public static void mostrarReservas() {
		System.out.println("Reservas cadastradas:");
		for(Reserva reserva:reservaPassagem.mostrarReservas()) {
			System.out.println(String.format("%d. Dia: %s as %s com o custo de %.2f;\nClasse %s e%spossui ida e volta", 
					reserva.getNumreserva(), reserva.getDataVoo(), reserva.getHoraVoo(), reserva.getPreco(),
					reserva.getClasseVoo(), (reserva.isIdaEvolta()) ? " ":" nao "));
		}
	}
	
	public static Cliente receberCliente() {
		System.out.println("Informacoes do cliente:");
		Cliente aux = new Cliente();
		System.out.println("CPF:");
		aux.setCpf(in.nextLine());
		System.out.println("Nome:");
		aux.setNome(in.nextLine());
		System.out.println("Endereco:");
		aux.setEndereco(in.nextLine());
		System.out.println("Telefone");
		aux.setTelefone((int) in.nextLong());
		in.nextLine();
		
		return aux;
	}
	
	public static Reserva receberReserva() {
		boolean sair = false;
		System.out.println("Informacoes da reserva:");
		Reserva aux = new Reserva();
		System.out.println("Numero da reserva:");
		aux.setNumreserva(in.nextInt());
		in.nextLine();
		System.out.println("Preco:");
		aux.setPreco(in.nextFloat());
		in.nextLine();
		System.out.println("Classe:");
		aux.setClasseVoo(in.nextLine());
		aux.setIdaEvolta(false);
		System.out.println("Cidade origem:");
		System.out.println("Cidades disponiveis:");
		while (!sair) {
			int count = 1;
			System.out.println("0.Cadastrar nova cidade");
			for (Cidade cidade : reservaPassagem.getListaDeCidades()) {
				System.out.println(count + "." + cidade.getNome() + " ; " + cidade.getEstado());
				count++;
			}
			int cid = in.nextInt();
			in.nextLine();
			if (cid == 0) {
				Cidade cidade = receberCidade();
				aux.setIdOrigem(cidade.getId());
				reservaPassagem.cadastrarCidade(cidade);
				sair = true;
				break;
			} else {
				try {
					aux.setIdOrigem(reservaPassagem.getListaDeCidades().get(cid - 1).getId());
					sair = true;
					break;
				} catch (Exception e) {
					System.out.println("Cidade nao encontrada");
				}
			}
		}
		System.out.println("Cidade destino:");
		sair = false;
		while (!sair) {
			int count = 1;
			System.out.println("0.Cadastrar nova cidade");
			for (Cidade cidade : reservaPassagem.getListaDeCidades()) {
				System.out.println(count + "." + cidade.getNome() + " ; " + cidade.getEstado());
				count++;
			}
			int cid = in.nextInt();
			in.nextLine();
			if (cid == 0) {
				Cidade cidade = receberCidade();
				aux.setIdDestino(cidade.getId());
				reservaPassagem.cadastrarCidade(cidade);
				sair = true;
				break;
			} else {
				try {
					aux.setIdDestino(reservaPassagem.getListaDeCidades().get(cid - 1).getId());
					sair = true;
					break;
				} catch (Exception e) {
					System.out.println("Cidade nao encontrada");
				}
			}
		}

		return aux;
	}

	public static Reserva receberReservaVolta() {
		boolean sair = false;
		System.out.println("Informacoes da reserva de volta:");
		Reserva aux = new Reserva();
		System.out.println("Numero da reserva:");
		aux.setNumreserva(in.nextInt());
		in.nextLine();
		System.out.println("Preco:");
		aux.setPreco(in.nextFloat());
		in.nextLine();
		System.out.println("Classe:");
		aux.setClasseVoo(in.nextLine());
		aux.setIdaEvolta(true);
		System.out.println("Cidade origem:");
		System.out.println("Cidades disponiveis:");
		while (!sair) {
			int count = 1;
			System.out.println("0.Cadastrar nova cidade");
			for (Cidade cidade : reservaPassagem.getListaDeCidades()) {
				System.out.println(count + "." + cidade.getNome() + " ; " + cidade.getEstado());
				count++;
			}
			int cid = in.nextInt();
			in.nextLine();
			if (cid == 0) {
				Cidade cidade = receberCidade();
				aux.setIdOrigem(cidade.getId());
				reservaPassagem.cadastrarCidade(cidade);
				sair = true;
				break;
			} else {
				try {
					aux.setIdOrigem(reservaPassagem.getListaDeCidades().get(cid - 1).getId());
					sair = true;
					break;
				} catch (Exception e) {
					System.out.println("Cidade nao encontrada");
				}
			}
		}
		sair = false;
		System.out.println("Cidade destino:");
		while (!sair) {
			int count = 1;
			System.out.println("0.Cadastrar nova cidade");
			for (Cidade cidade : reservaPassagem.getListaDeCidades()) {
				System.out.println(count + "." + cidade.getNome() + " ; " + cidade.getEstado());
				count++;
			}
			int cid = in.nextInt();
			in.nextLine();
			if (cid == 0) {
				Cidade cidade = receberCidade();
				aux.setIdDestino(cidade.getId());
				reservaPassagem.cadastrarCidade(cidade);
				sair = true;
				break;
			} else {
				try {
					aux.setIdDestino(reservaPassagem.getListaDeCidades().get(cid - 1).getId());
					sair = true;
					break;
				}catch(Exception e) {
					System.out.println("Cidade nao encontrada");
				}
			}
		}
		
		return aux;
	}
	
	public static Trecho receberTrecho() {
		boolean sair = false;
		System.out.println("Informacoes do trecho:");
		Trecho aux = new Trecho();
		System.out.println("Numero do trecho:");
		aux.setNumtrecho(in.nextInt());
		in.nextLine();
		System.out.println("duracao:");
		aux.setDuracao(in.nextInt());
		in.nextLine();
		System.out.println("Data de partida");
		aux.setClassevoo(in.nextLine());
		System.out.println("Aeroporto origem:");
		while(!sair) {
			int count = 1;
			System.out.println("0.Cadastrar novo aeroporto");
			for(Aeroporto aeroporto:reservaPassagem.getListaDeAeroportos()) {
				System.out.println(count + "." + aeroporto.getNome() + " ; " + aeroporto.getCodigo());
				count++;
			}
			int aer = in.nextInt();
			in.nextLine();
			if(aer == 0) {
				Aeroporto aero = receberAeroporto();
				aux.setIdaeroorigem(aero.getId());
				reservaPassagem.cadastrarAeroporto(aero);
				sair = true;
				break;
			} else {
				try {
					aux.setIdaeroorigem(reservaPassagem.getListaDeAeroportos().get(aer - 1).getId());
					sair = true;
					break;
				}catch(Exception e) {
					System.out.println("Aeroporto nao encontrado");
				}
			}
		}
		sair = false;
		System.out.println("Aeroporto Destino:");
		while(!sair) {
			int count = 1;
			System.out.println("0.Cadastrar novo aeroporto");
			for(Aeroporto aeroporto:reservaPassagem.getListaDeAeroportos()) {
				System.out.println(count + "." + aeroporto.getNome() + " ; " + aeroporto.getCodigo());
				count++;
			}
			int aer = in.nextInt();
			in.nextLine();
			if(aer == 0) {
				Aeroporto aero = receberAeroporto();
				aux.setIdaerodestino(aero.getId());
				reservaPassagem.cadastrarAeroporto(aero);
				sair = true;
				break;
			} else {
				try {
					aux.setIdaerodestino(reservaPassagem.getListaDeAeroportos().get(aer - 1).getId());
					sair = true;
					break;
				}catch(Exception e) {
					System.out.println("Aeroporto nao encontrado");
				}
			}
		}
		
		return aux;
	}
	
	public static int receberPoltrona() {
		System.out.println("Poltrona:");
		return in.nextInt();
	}
	
	public static Aeroporto receberAeroporto() {
		boolean sair = false;
		Aeroporto aux = new Aeroporto();
		System.out.println("Informacoes do aeroporto");
		System.out.println("Codigo:");
		aux.setCodigo(in.nextLine());
		System.out.println("Nome:");
		aux.setNome(in.nextLine());
		System.out.println("Cidades disponiveis:");
		while(!sair) {
			int count = 1;
			System.out.println("0.Cadastrar nova cidade");
			for(Cidade cidade:reservaPassagem.getListaDeCidades()) {
				System.out.println(count + "." + cidade.getNome() + " ; " + cidade.getEstado());
				count++;
			}
			int cid = in.nextInt();
			in.nextLine();
			if(cid == 0) {
				Cidade cidade = receberCidade();
				aux.setIdCidade(cidade.getId());
				reservaPassagem.cadastrarCidade(cidade);
				sair = true;
				break;
			} else {
				try {
					aux.setIdCidade(reservaPassagem.getListaDeCidades().get(cid - 1).getId());
					reservaPassagem.getListaDeCidades().get(cid-1).addAeroporto(aux);
					sair = true;
					break;
				}catch(Exception e) {
					System.out.println("Cidade nao encontrada");
				}
			}
		}
		return aux;
	}
	
	public static Cidade receberCidade() {
		Cidade aux = new Cidade();
		System.out.println("Informacoes da cidade");
		System.out.println("Nome:");
		aux.setNome(in.nextLine());
		System.out.println("Estado:");
		aux.setEstado(in.nextLine());
		return aux;
	}
}