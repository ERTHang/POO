import java.util.*;

public class exercicio1{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    for (int i = 0;i < 10;i++) {
      System.out.printf("%d\n", x*(i+1));
    }
  }
}
