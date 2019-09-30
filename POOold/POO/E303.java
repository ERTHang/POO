import java.util.Scanner;

public class E303{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int[][] matrix = new int[3][2];
    int[][] matrixt = new int[2][3];

    for(int i=0;i<3;i++){
      for(int j=0;j<2;j++){
        matrix[i][j] = in.nextInt();
        matrixt[j][i] = matrix[i][j];
      }
    }

    System.out.println("Matriz original:");
    for(int i=0;i<3;i++){
      for(int j=0;j<2;j++){
        System.out.printf("%d ", matrix[i][j]);
      }
      System.out.println();
    }

    System.out.println("Matrix transposta:");
    for(int i=0;i<2;i++){
      for(int j=0;j<3;j++){
        System.out.printf("%d ", matrixt[i][j]);
      }
      System.out.println();
    }
  }
}
