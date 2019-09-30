import java.util.Scanner;

public class Ex2{
    public static void main(String[] args){
        Scanner ENT = new Scanner(System.in);
        int TAM = ENT.nextInt();
        int[][] MATRIZ = new int[TAM][TAM];
        for (int i = 0; i < TAM; i++) {
            ENT = new Scanner(System.in);
            for (int j = 0; j < TAM; j++) {
                MATRIZ[i][j] = ENT.nextInt();
            }
        }
        int DET = 0;
        for (int i = 0; i < ((TAM == 2) ? 1 : TAM); i++) {
            int AUX = 1;
            for (int j = 0; j < TAM; j++) {
                AUX *= MATRIZ[j][(j+i)%TAM];
            }
            DET += AUX;
        }
        for (int i = 0; i < ((TAM == 2) ? 1 : TAM); i++) {
            int AUX = 1;
            for (int j = 0; j < TAM; j++) {
                AUX *= MATRIZ[j][(TAM - 1) - ((j + i)%TAM)];
            }
            DET -= AUX;
        }
        System.out.println("Det = " + DET);
        ENT.close();
    }
}