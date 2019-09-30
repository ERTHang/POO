import java.util.*;

public class E305{
  public static void main(String[] args){
    Scanner en = new Scanner(System.in);
    String nomes[] = new String[10];
    double media[] = new double[10];
    for (int i = 0; i < 10 ; i++ ) {
      nomes[i] = en.nextLine();
      media[i] = 0;
    }
    for (int i = 0; i < 10 ; i++ ) {
      for(int j = 0; j < 4; j++)
        media[i] += en.nextDouble();
      media[i] /= 4;
    }
    double temp;
    String aux;
    for (int i = 1; i < 10 ; i++ ) {
      for (int j = i; j > 0 ; j-- ) {
        if(media[j] > media[j-1]){
          temp = media[j];
          media[j] = media[j-1];
          media[j - 1] = temp;

          aux = nomes[j];
          nomes[j] = nomes[j - 1];
          nomes[j - 1] = aux;
        }
      }
    }
    int a = 0;
    for (String i: nomes) {
      System.out.printf("%s, com a media %.2f\n", i, media[a]);
      a++;
    }
  }
}
