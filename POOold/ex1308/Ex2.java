import java.util.*;

public class Ex2{
    public static void main(String[] args){
        boolean b = true;
        while(true){
                Scanner n = new Scanner(System.in);
                String lista;
                lista = n.nextLine();
                if(lista.length() != 5){
                    System.out.println("Numero maior que 5, digite outro");
                    continue;
                }
                for(int i=0;i<2;i++){
                    if(lista.charAt(i) != lista.charAt(4-i)){
                        b = false;
                        break;
                    }
                }
                if(b){
                    System.out.println("palindromo");
                }
                else{
                    System.out.println("Nao palindromo");
                }
                break;
            }
    }
}
