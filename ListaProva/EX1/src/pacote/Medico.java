package pacote;

public class Medico extends Pessoa{
	
	private String especializacao;
	
	/*public Medico(String especializacao) {
		super();   
		this.especializacao = especializacao;
	}*/
	// Errado pois está chamando o construtor de pessoa sem parametros, correto:
	
	public Medico(String nome, int idade, String especializacao) {
		super(nome, idade);
		this.especializacao = especializacao;
	}
}
