package app;

import java.util.Scanner;

public class AutomovelApp {
    private static Oficina ofc = new Oficina();
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            System.out.println();
            System.out.println("Aperte enter para ir ao proximo veiculo (digite \"sair\" para sair)");
            String aux = in.nextLine();
            if(aux.equals("sair")){
                break;
            }
            System.out.println("Veiculo : ");
            Veiculo v = ofc.proximo();
            System.out.println(v.toString());
            ofc.manutencao(v);
        }
    }
}