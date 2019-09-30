import java.util.Scanner;

public class E301{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int[] num = new int[50];
    int sum = 0;

    for(int i=0;i<50;i++){
      num[i] = in.nextInt();
      sum += num[i];
    }

    double media = sum/50.0;
    System.out.println("Soma dos 50 termos: " + sum + ", média = " + media);

    System.out.println("Valores abaixo da média:");
    for(int i=0;i<50;i++){
      if(media > num[i]){
        System.out.printf("%d na posição %d\n", num[i], i);
      }
    }
  }
}
