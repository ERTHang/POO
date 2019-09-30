package logica;

import dados.Veiculo;

public class Revenda {

	Veiculo[] veiculos;
	int quantVeiculos = 0;
	int quantVeiculosVendidos = 0;

	public Revenda(int tam) {
		veiculos = new Veiculo[tam];
	}

	public int getQuantVeiculos() {
		return quantVeiculos;
	}

	public void cadastraVeiculo(Veiculo v) {
		veiculos[quantVeiculos] = v;
		quantVeiculos++;
	}

	public Veiculo[] getVeiculos() {
		return veiculos;
	}

	public Veiculo[] getVeiculoNaoVendidos() {
		Veiculo[] v = new Veiculo[quantVeiculos - quantVeiculosVendidos];
		int quantNaoVendido = 0;
		for (int i = 0; i < quantVeiculos; i++) {
			if (!veiculos[i].isVendido()) {
				v[quantNaoVendido] = veiculos[i];
				quantNaoVendido++;
			}
		}
		return v;
	}

	public void vendaVeiculo(Veiculo v) {
		for (int i = 0; i < quantVeiculos; i++) {
			if (veiculos[i].equals(v)) {
				veiculos[i].setVendido(true);
				quantVeiculosVendidos++;
				break;
			}
		}

	}
}
