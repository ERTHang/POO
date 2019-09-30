import java.util.*;

public class exercicio3{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int l1 = sc.nextInt();
    int l2 = sc.nextInt();
    int l3 = sc.nextInt();
    if(l1 == 0 || l2 == 0 || l3 == 0 || l1 > l2 + l3 || l2 > l1 + l3 || l3 > l1 + l2){
      System.out.println("Nao e um triangulo");
    }
    else if(l1 == l2 && l1 == l3)
            System.out.println("Triângulo Equilátero.");
        else if(l1 != l2 && l1 != l3 && l2 != l3)
            System.out.println("Triângulo Escaleno.");
        else
            System.out.println("Triângulo Isósceles.");
  }
}
