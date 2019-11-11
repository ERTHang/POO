package negocio;
import java.util.*;
import dados.*;
import persistencia.*;

public class ReservaPassagem {
	private CidadeDAO cidadedao = CidadeDAO.getInstance();
	private ClienteDAO clientedao = ClienteDAO.getInstance();
	private AeroportoDAO aeroportodao = AeroportoDAO.getInstance();
	private ReservaDAO reservadao = ReservaDAO.getInstance();

	public void cadastrarCidade(Cidade cidade) {
		cidadedao.insert(cidade);
		
	}

	public void cadastrarCliente(Cliente cliente) {
		clientedao.insert(cliente);
	}

	public void cadastrarAeroporto(Aeroporto aeroporto) {
		aeroportodao.insert(aeroporto);
	}

	public void reservarIda(Cliente cliente, Reserva reserva) {
		cliente.reservarIda(reserva);
		clientedao.insert(cliente);
	}

	public void reservarVolta(Cliente cliente, Reserva ida, Reserva volta) {
		cliente.reservarVolta(ida, volta);
		clientedao.insert(cliente);
	}

	public void reservarTrecho(Cliente cliente, Reserva reserva, Trecho trecho) {
		cliente.reservarTrecho(reserva, trecho);
		clientedao.insert(cliente);
	}

	public void reservarPoltrona(Cliente cliente, Reserva reserva, Trecho trecho, int poltrona) {
		cliente.reservarPoltrona(reserva, trecho, poltrona);
		clientedao.insert(cliente);
	}

	public ArrayList<Reserva> mostrarReservas(String cpfCliente) {
        ArrayList<Reserva> aux = new ArrayList<Reserva>();
		for(Cliente cliente:clientedao.getClientes()) {
			if(cliente.getCpf() == cpfCliente) {
				for (Reserva reserva : reservadao.getReservas()) {
                    if (reserva.getIdCliente() == cliente.getId()) {
                        aux.add(reserva);
                    }
                }
			}
		}
		return aux;
	}

	public ArrayList<Reserva> mostrarReservas() {
		return reservadao.getReservas();
	}

	public ArrayList<Cidade> getListaDeCidades() {
		return cidadedao.getCidades();
	}

	public ArrayList<Cliente> getListaDeClientes() {
		return clientedao.getClientes();
	}

	public ArrayList<Aeroporto> getListaDeAeroportos() {
		return aeroportodao.getAeroportos();
	}


}
