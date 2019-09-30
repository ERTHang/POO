import java.util.Scanner;

public class E302{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int[][] matrix = new int[5][5];

    int sum = 0;
    for(int i=0;i<5;i++){
      for(int j=0;j<5;j++){
        matrix[i][j] = in.nextInt();
        if(j < i)
          sum += matrix[i][j];
      }
    }

    System.out.println();
    for(int i=0;i<5;i++){
      for(int j=0;j<5;j++){
        System.out.printf("%d ", matrix[i][j]);
      }
      System.out.println();
    }
    System.out.printf("Soma dos termos = %d\n", sum);
  }

}
