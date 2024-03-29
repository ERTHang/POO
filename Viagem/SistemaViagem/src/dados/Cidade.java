package dados;
import java.util.ArrayList;

public class Cidade {
	private String nome;
	private String estado;
	private ArrayList<Aeroporto>aeroportos = new ArrayList<Aeroporto>();
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void addAeroporto(Aeroporto aeroporto) {
		aeroportos.add(aeroporto);
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public Aeroporto getAeroporto(int pos) {
		return aeroportos.get(pos);
	}
}
