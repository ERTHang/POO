import java.util.*;

public class Ex3{
    public static void main(String[] args){
        Scanner n = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<Integer>();
        String cpf = n.nextLine();
        for (int i = 0; i < cpf.length(); i++){
            lista.add((int)cpf.charAt(i) - (int)'0');
        }
        int a = 10;
        int soma = 0;
        for(Integer i: lista){
            soma += a * i;
            a--;
        }
        int x1 = (soma%11 > 2) ? (11 - (soma%11)): 0;
        cpf += Integer.toString(x1);
        lista.add(x1);
        a = 11;
        soma = 0;
        for(Integer i: lista){
            soma += a * i;
            a--;
        }
        x1 = (soma%11 > 2) ? (11 - (soma%11)): 0;
        cpf += Integer.toString(x1);
        System.out.println(cpf);
        n.close();
    }
}
