import java.util.Scanner;


public class SistemaEmpresa {
	private Empresa empresa = new Empresa();
	
	Scanner in = new Scanner(System.in);
	
	public Empresa getEmpresa() {
		return this.empresa;
	}
	
	public void cadEmpresa() {
		System.out.println("Nome:");
		empresa.setNome(in.nextLine());
	}
	
	public void cadEndEmpreso() {
		Endereco aux = new Endereco();
		
		System.out.println("CEP:");
		aux.setCep(in.nextLine());
		System.out.println("Rua:");
		aux.setRua(in.nextLine());
		System.out.println("Numero");
		aux.setNumero(in.nextInt());
		in.nextLine();
		System.out.println("Bairro:");
		aux.setBairro(in.nextLine());
		System.out.println("Cidade:");
		aux.setCidade(in.nextLine());
		System.out.println("Estado:");
		aux.setEstado(in.nextLine());
		
		empresa.setEndereco(aux);
	}
	
	public void cadFuncionario() {
		Funcionarios aux = new Funcionarios();
		
		System.out.println("Nome:");
		aux.setNome(in.nextLine());
		System.out.println("Nro Filhos:");
		aux.setNumFilhos(in.nextInt());
		in.nextLine();
		
		empresa.setFuncionario(aux);
	}
	
	public void cadEndFuncionario(int pos) {
		Endereco aux = new Endereco();
		
		System.out.println("CEP:");
		aux.setCep(in.nextLine());
		System.out.println("Rua:");
		aux.setRua(in.nextLine());
		System.out.println("Numero");
		aux.setNumero(in.nextInt());
		in.nextLine();
		System.out.println("Bairro:");
		aux.setBairro(in.nextLine());
		System.out.println("Cidade:");
		aux.setCidade(in.nextLine());
		System.out.println("Estado:");
		aux.setEstado(in.nextLine());
		
		empresa.getFuncionario(pos).setEndereco(aux);
	}
	
	public void cadCargos() {
		Cargo aux = new Cargo();
		
		System.out.println("Nome");
		aux.setNome(in.nextLine());
		System.out.println("Descrição:");
		aux.setDescricao(in.nextLine());
		System.out.println("Salário Base:");
		aux.setSalarioBase(in.nextDouble());
		System.out.println("Valor Hora Extra:");
		aux.setHoraExtra(in.nextDouble());
		System.out.println("Valor por Filho");
		aux.setValorFilho(in.nextDouble());
		in.nextLine();
		empresa.setCargos(aux);
	}
	
	public void defCargoFunc(int posCargo, int posFunc) {
		empresa.getFuncionario(posFunc).setCargo(empresa.getCargos(posCargo));
	}
	
	public void salLiqFunc(int pos) {
		System.out.println(empresa.getFuncionario(pos).salLiq());
	}
	
	public void salBrutoFunc(int pos) {
		System.out.println(empresa.getFuncionario(pos).salBruto());
	}
	
	public void descontosFunc(int pos) {
		System.out.println(empresa.getFuncionario(pos).calcDescontos());
	}
	
	public void horaExtraFunc(int pos) {
		System.out.println(empresa.getFuncionario(pos).getNumHora());
	}
	
	public void beneficiosFunc(int pos) {
		System.out.println(empresa.getFuncionario(pos).calcAcrescimos());
	}
	
	
}
