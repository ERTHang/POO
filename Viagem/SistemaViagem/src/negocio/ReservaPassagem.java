package negocio;
import java.util.*;
import dados.*;

public class ReservaPassagem {
	private ArrayList<Cidade>listaDeCidades = new ArrayList<Cidade>();
	private ArrayList<Cliente>listaDeClientes = new ArrayList<Cliente>();
	private ArrayList<Aeroporto>listaDeAeroportos = new ArrayList<Aeroporto>();
	
	public void cadastrarCidade(Cidade cidade) {
		this.listaDeCidades.add(cidade);
	}
	
	public void cadastrarCliente(Cliente cliente) {
		this.listaDeClientes.add(cliente);
	}
	
	public void cadastrarAeroporto(Aeroporto aeroporto) {
		this.listaDeAeroportos.add(aeroporto);
	}
	
	public void reservarIda(Cliente cliente, Reserva reserva) {
		cliente.reservarIda(reserva);
		listaDeClientes.add(cliente);
	}
	
	public void reservarVolta(Cliente cliente, Reserva ida, Reserva volta) {
		cliente.reservarVolta(ida, volta);
		listaDeClientes.add(cliente);
	}
	
	public void reservarTrecho(Cliente cliente, Reserva reserva, Trecho trecho) {
		cliente.reservarTrecho(reserva, trecho);
		listaDeClientes.add(cliente);
	}
	
	public void reservarPoltrona(Cliente cliente, Reserva reserva, Trecho trecho, int poltrona) {
		cliente.reservarPoltrona(reserva, trecho, poltrona);
		listaDeClientes.add(cliente);
	}
	
	public ArrayList<Reserva> mostrarReservas(int cpfCliente) {
		for(Cliente cliente:listaDeClientes) {
			if(cliente.getCpf() == cpfCliente) {
				return cliente.getReservas();
			}
		}
		return null;
	}
	
	public ArrayList<Reserva> mostrarReservas() {
		ArrayList<Reserva> lista = new ArrayList<Reserva>();
		for(Cliente cliente:listaDeClientes) {
			lista.addAll(cliente.getReservas());
		}
		return lista;
	}

	public ArrayList<Cidade> getListaDeCidades() {
		return listaDeCidades;
	}

	public ArrayList<Cliente> getListaDeClientes() {
		return listaDeClientes;
	}

	public ArrayList<Aeroporto> getListaDeAeroportos() {
		return listaDeAeroportos;
	}
	
	
}
