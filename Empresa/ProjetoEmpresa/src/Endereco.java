
public class Endereco {
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private int numero;
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public void setNumero(int num) {
		this.numero = num;
	}
	
	public String getRua() {
		return this.rua;
	}
	
	public String getBairro() {
		return this.bairro;
	}
	
	public String getCidade() {
		return this.cidade;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public String getCep() {
		return this.cep;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
}
