import java.util.Scanner;
import java.util.ArrayList;

public class Ex1{
    public static void main(String[] args){
        Scanner ENT = new Scanner(System.in);
        int NUM = ENT.nextInt();
        ArrayList<Integer> VETOR = new ArrayList<Integer>();
        double SNUM = Math.floor(Math.sqrt(NUM));
        for(int i = 2; i <= NUM; i++){
            VETOR.add(i);
        }
        for (int i = 0; VETOR.get(i) <= SNUM; i++) {
            for (int j = i + 1; j < VETOR.size(); j++) {
                if(VETOR.get(j) % VETOR.get(i) == 0){
                    VETOR.remove(j);
                }
            }
        }
        System.out.print("(");
        for (int j = 0; j < VETOR.size(); j++) {
            System.out.print(VETOR.get(j));
            if(VETOR.get(j) != VETOR.get(VETOR.size() - 1)){
                System.out.print(", ");
            }
        }
        System.out.println(")");
        ENT.close();
    }
}