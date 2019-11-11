package dados;

import persistencia.ReservaDAO;

/**
 * Cliente
 */
public class Cliente {

    private int id;
    private String cpf;
    private String nome;
    private String endereco;
    private int telefone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

	public void reservarIda(Reserva reserva) {
        ReservaDAO reservadao = ReservaDAO.getInstance();
        reservadao.insert(reserva);
	}

	public void reservarVolta(Reserva ida, Reserva volta) {
        ida.setIdVolta(volta.getId());
        ReservaDAO reservadao = ReservaDAO.getInstance();
        reservadao.insert(ida);
        reservadao.insert(volta);

	}

	public void reservarTrecho(Reserva reserva, Trecho trecho) {
	}

	public void reservarPoltrona(Reserva reserva, Trecho trecho, int poltrona) {
	}

}