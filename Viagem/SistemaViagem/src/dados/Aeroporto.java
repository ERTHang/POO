package dados;

public class Aeroporto {
	private String codigo;
	private String nome;
	private Cidade cidade = new Cidade();
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Cidade getCidade() {
		return this.cidade;
	}
}
