import java.util.*;

public class E306{
  public static void main(String[] args){
    int i1;
    int j1;
    int i2;
    int j2;
    while(true){
      System.out.println("Digite a ordem da matriz 1 e logo após da matriz 2:");
      Scanner en = new Scanner(System.in);
      i1 = en.nextInt();
      j1 = en.nextInt();
      i2 = en.nextInt();
      j2 = en.nextInt();
      if(j1 == i2)
        break;
      else
        System.out.println("Erro 0x9654986, contate o suporte");
    }
    int matriz1[][] = new int[i1][j1];
    int matriz2[][] = new int[i2][j2];
    int M[][] = new int[i1][j2];
    System.out.println("Digite a matriz1 e a matriz2: ");
    Scanner en = new Scanner(System.in);
    for(int i=0;i<i1;i++){
      for(int j=0;j<j1;j++)
        matriz1[i][j] = en.nextInt();
    }
    for(int i=0;i<i2;i++){
      for(int j=0;j<j2;j++)
        matriz2[i][j] = en.nextInt();
    }
    for (int i = 0; i < i1; i++)
    {
        for (int j = 0; j < j2; j++)
        {
            M[i][j] = 0;
            for (int k = 0; k < i2; k++)
            {
                M[i][j] += matriz1[i][k] * matriz2[k][j];
            }
        }
    }
    System.out.printf("M:\n");
    for (int i = 0; i < i1; i++)
    {
        for (int j = 0; j < j2; j++)
        {
            System.out.printf("%d ", M[i][j]);
        }
        System.out.printf("\n");
    }



  }
}
