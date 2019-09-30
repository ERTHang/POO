package pacote;

public class Ponto2D {
//class Ponto2D 
//incorreto pois Ponto2D precisa de um escopo
	
	private double x, y;
	
	/*Ponto2D(double _x, double _y){
		
	}*/
	//incorreto, pois o construtor precisa ser publico para ser acessado por outras classes
	public Ponto2D(double _x, double _y){
		x = _x;y = _y;
	}
}
