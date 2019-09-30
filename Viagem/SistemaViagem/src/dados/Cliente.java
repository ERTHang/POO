package dados;
import java.util.*;

public class Cliente {
	private int cpf;
	private String nome;
	private String endereco;
	private Long telefone;
	private ArrayList<Reserva>reservas = new ArrayList<Reserva>();
	
	public void reservarIda(Reserva reserva) {
		reservas.add(reserva);
	}
	
	public void reservarVolta(Reserva ida, Reserva volta) {
		ida.setVolta(volta);
		reservas.add(ida);
	}
	
	public void reservarTrecho(Reserva reserva, Trecho trecho) {
		reserva.reservarTrecho(trecho);
		reservas.add(reserva);
	}
	
	public void reservarPoltrona(Reserva reserva, Trecho trecho, int poltrona) {
		reserva.reservarPoltrona(trecho, poltrona);
		reservas.add(reserva);
	}

	public ArrayList<Reserva> getReservas(){
		return this.reservas;
	}

	public int getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setTelefone(long l) {
		this.telefone = l;
	}
	
	public void addReserva(Reserva reserva) {
		reservas.add(reserva);
	}
}
