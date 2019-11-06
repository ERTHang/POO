package apresentacao;

import dados.Cidade;
import persistencia.CidadeDAO;

public class Principal {

	public static void main(String[] args) {
		Cidade cidade = new Cidade();
		
		cidade.setNome("Joinville");
		cidade.setEstado("SC");
		
		CidadeDAO cidadedao = CidadeDAO.getInstance();
		cidadedao.insert(cidade);
		
		Cidade cidadereceive = cidadedao.select(cidadedao.menorID());
		
		System.out.println(cidadereceive.getNome() + " - " + cidadereceive.getEstado());
		
		cidadedao.delete(cidadedao.menorID());
		
		
	}
	
}
