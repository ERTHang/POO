
public class Agenda {
	private Contato[] contatos = new Contato[15];
	private int quantContatos = 0;
	
	public Contato getContato(int index) {
		return this.contatos[index];
	}
	
	public void setContato(Contato novoContato) {
		contatos[quantContatos] = new Contato();
		insereContato(novoContato.getTelefone(), novoContato.getNome(), novoContato.getEmail(), novoContato.getEndereco());
	}
	
	public void insereContato(Long telefone, String nome, String email, String endereco) {
		contatos[quantContatos].setNome(nome);
		contatos[quantContatos].setEmail(email);
		contatos[quantContatos].setTelefone(telefone);
		contatos[quantContatos].setEndereco(endereco);
		quantContatos++;
	}
	
	public Contato consultaContato(long telefone) {
		for(int i = 0; i < quantContatos; i++) {
			if (contatos[i].getTelefone() == telefone){
				return contatos[i];
			}
		}
		return null;
	}
	
	public int removeContato(int telefone) {
		int removido = 0;
		for(int i = 0; i < quantContatos+removido; i++) {
			if(removido == 1) {
				contatos[i-1].setEmail(contatos[i].getEmail());
				contatos[i-1].setTelefone(contatos[i].getTelefone());
				contatos[i-1].setNome(contatos[i].getNome());
				contatos[i-1].setEndereco(contatos[i].getEndereco());
			}
			if (contatos[i].getTelefone() == telefone){
				contatos[i].setNome(null);
				contatos[i].setEmail(null);
				contatos[i].setEndereco(null);
				contatos[i].setTelefone((long) 0);
				removido = 1;
				quantContatos--;
			}
		}
		return removido;
	}
	
	
}
