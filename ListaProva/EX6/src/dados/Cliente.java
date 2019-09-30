package dados;

import java.util.ArrayList;

public class Cliente {

	private int cpf;
	private String nome;
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

	public ArrayList<Produto> getProdutosComprados() {
		return listaProdutos;
	}

	public void setProdutosComprados(ArrayList<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return "CPF = " + cpf + ", Nome = " + nome;
	}

}
