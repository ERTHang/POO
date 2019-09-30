package classes;

public class Main {
	public static void main(String[] args) {
		Turma udesc = new Turma();
		udesc.receberAlunos();
		try {
			udesc.printAlunos();
		}
		catch(Exception e) {
			System.out.println("erro");
		}
	}
}
