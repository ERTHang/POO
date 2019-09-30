public class Estudante{
	public String nome;
	public int[] nota = new int[4];
	public int media;
	
	public void setNome (String NOME) {
		nome = NOME;
	}
	
	public void setNota (int NOTA, int i) {
		nota[i] = NOTA;
	}
	
	public String getNome () {
		return nome;
	}
	
	public int getNota (int i) {
		return nota[i];
	}
	
	public int getMedia(int notas[]) {
		media = 0;
		for (int i : notas) {
			media += i;
		}
		media /= 4;
		return media;
	}
	
	
}