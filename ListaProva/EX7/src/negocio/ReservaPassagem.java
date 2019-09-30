package negocio;

import dados.*;
import java.util.ArrayList;

public class ReservaPassagem {

	private ArrayList<Viagem> listaViagens = new ArrayList<Viagem>();
	private ArrayList<Passageiro> listaPassageiros = new ArrayList<Passageiro>();
	private ArrayList<Cidade> listaCidade = new ArrayList<Cidade>();
	private ArrayList<Onibus> listaOnibus = new ArrayList<Onibus>();

	public void listarOnibus() {
		int i = 1;
		for(Onibus onibus : listaOnibus) {
			System.out.println(i + ". " + onibus.getCodigo());
			i++;
		}
	}
	
	public Passageiro ultimoPassageiro() {
		return listaPassageiros.get(listaPassageiros.size() - 1);
	}
	
	public Onibus ultimoOnibus() {
		return listaOnibus.get(listaOnibus.size() - 1);
	}
	
	public Cidade ultimaCidade() {
		return listaCidade.get(listaCidade.size() - 1);
	}
	
	public Viagem ultimaViagem() {
		return listaViagens.get(listaViagens.size() - 1);
	}
	
	public void listarCidades() {
		int i = 1;
		for(Cidade cidade : listaCidade) {
			System.out.println(i + ". " + cidade.getNome());
			i++;
		}
	}
	
	public void listarViagens() {
		int i = 1;
		for(Viagem viagem: listaViagens) {
			System.out.println(i + ". " + viagem.getCodigo());
			i++;
		}
	}
	
	public void listarPassageiros() {
		int i = 1;
		for(Passageiro passageiro : listaPassageiros) {
			System.out.println(i + ". " + passageiro.getNome());
			i++;
		}
	}
	
	public ArrayList<Viagem> getListaViagens() {
		return listaViagens;
	}

	public void setListaViagens(ArrayList<Viagem> listaViagens) {
		this.listaViagens = listaViagens;
	}

	public ArrayList<Passageiro> getListaPassageiros() {
		return listaPassageiros;
	}

	public void setListaPassageiros(ArrayList<Passageiro> listaPassageiros) {
		this.listaPassageiros = listaPassageiros;
	}

	public ArrayList<Cidade> getListaCidade() {
		return listaCidade;
	}

	public void setListaCidade(ArrayList<Cidade> listaCidade) {
		this.listaCidade = listaCidade;
	}

	public ArrayList<Onibus> getListaOnibus() {
		return listaOnibus;
	}

	public void setListaOnibus(ArrayList<Onibus> listaOnibus) {
		this.listaOnibus = listaOnibus;
	}

	public void cadastrarCidade(Cidade cidade) {
		listaCidade.add(cidade);
	}

	public void cadastrarOnibus(Onibus onibus) {
		listaOnibus.add(onibus);
	}

	public void cadastrarPassageiro(Passageiro passageiro) {
		listaPassageiros.add(passageiro);
	}

	public void cadastrarViagem(Viagem viagem) {
		listaViagens.add(viagem);
	}

	public boolean reservarIda(Passageiro passageiro, Viagem viagem, int assento) {
		for (Viagem v : listaViagens) {
			if (v.getCodigo() == viagem.getCodigo()) {
				if (v.getOnibus().getNumeroAssentos() < assento) {
					System.out.println("Assento não disponível");
					return false;
				} else {
					for (int i = 0; i < v.getOnibus().getNumeroAssentos(); i++) {
						if (assento == v.getOnibus().getAssentos().get(i).getNumero()) {
							if (v.getOnibus().getAssentos().get(i).isOcupado()) {
								System.out.println("Assento não disponível");
								return false;

							} else {
								passageiro.setViagem(viagem);
								passageiro.getViagem().getOnibus().getAssentos().get(i).setOcupado(true);
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	public boolean reservarVolta(Passageiro passageiro, Viagem viagem, int assento) {
		for (Viagem v : listaViagens) {
			if (v.getCodigo() == viagem.getCodigo()) {
				if (v.getVolta() == null) {
					v.setVolta(viagem);
				} else {
					if (v.getVolta().getOnibus().getNumeroAssentos() < assento) {
						System.out.println("Assento não disponível");
						return false;
					} else {
						for (int i = 0; i < v.getVolta().getOnibus().getNumeroAssentos(); i++) {
							if (assento == v.getVolta().getOnibus().getAssentos().get(i).getNumero()) {
								if (v.getVolta().getOnibus().getAssentos().get(i).isOcupado()) {
									System.out.println("Assento não disponível");
									return false;

								} else {
									passageiro.setViagem(viagem);
									passageiro.getViagem().getOnibus().getAssentos().get(i).setOcupado(true);
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
}
