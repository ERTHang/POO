
public class App {
	
	public static void main(String[] args) {
		System.out.println("Quadrado: ");
		Quadrado quadrado = new Quadrado(2);
		System.out.println("Area: " + quadrado.getArea());
		System.out.println("Cubo: ");
		Cubo cubo = new Cubo(2);
		System.out.println("Area: " + cubo.getArea());
	}
	
}
