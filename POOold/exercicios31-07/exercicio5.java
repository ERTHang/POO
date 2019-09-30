import java.util.*;

public class exercicio5{
    public static int fat(int i){
        return (i == 1) ? 1:i * fat(i - 1);
    }

    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int i = read.nextInt();
        int fat = fat(i);
        System.out.println(fat);

    }
}