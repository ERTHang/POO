import java.util.Scanner;

public class E304{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int[][] matrixA = new int[3][2];
    int[][] matrixB = new int[3][2];
    int[][] matrixC = new int[3][2];

    for(int i=0;i<3;i++){
      for(int j=0;j<2;j++)
        matrixA[i][j] = in.nextInt();
    }

    for(int i=0;i<3;i++){
      for(int j=0;j<2;j++)
        matrixB[i][j] = in.nextInt();
    }
    for(int i=0;i<3;i++){
      for(int j=0;j<2;j++)
        matrixC[i][j] = (i <= j)? matrixA[i][j] : matrixB[i][j];
    }
    System.out.println();
    for(int i=0;i<3;i++){
      for(int j=0;j<2;j++)
        System.out.printf("%d ", matrixC[i][j]);
      System.out.println();
    }

  }
}
