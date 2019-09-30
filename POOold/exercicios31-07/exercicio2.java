import java.util.*;

public class exercicio2{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    if(x >= 0 && x < 5){
      System.out.println(x);
    }
    else if (x >= 5 && x < 10){
      System.out.println(2*x+1);
    }
    else{
      System.out.println(x-3);
    }
  }
}
