package pacote;

public class Ponto3D extends Ponto2D{
	
	private double z;
	
	/*Ponto3D(double x, double y, double z){
		x = _x;
		y = _y;
		z = _z;
	}*/
	//incorreto, pois construtor está sem public e argumentos com nomes diferentes, 
	//além de tentar acessar atributos privados do pai
	//correto:
	
	public Ponto3D(double x, double y, double z){
		super(x, y);
		this.z = z;
	}
	
}
