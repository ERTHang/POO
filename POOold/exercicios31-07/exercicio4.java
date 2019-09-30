import java.util.*;
import java.lang.Math;

public class exercicio4{
  public static void main(String[] args){
    int qnt = 0;
    while(true){
      Scanner sc = new Scanner(System.in);
      float peso = sc.nextFloat();
      if (peso == -1) {
        break;
      }
      float altura = sc.nextFloat();
      if(altura == -1){
        break;
      }
      if(peso/Math.pow(altura, 2) > 25){
        qnt++;
      }
    }
    System.out.printf("%d pessoas estao acima do peso", qnt);

  }
}
