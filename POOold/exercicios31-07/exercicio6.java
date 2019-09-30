import java.util.*;

public class exercicio6 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int money = read.nextInt();
        int temp;
        // 50
        temp = money / 50;
        if (temp != 0) {
            System.out.printf("%d nota(s) de 50\n", temp);
        }
        money -= temp * 50;
        // 20
        temp = money / 20;
        if (temp != 0) {
            System.out.printf("%d nota(s) de 20\n", temp);
        }
        money -= temp * 20;
        // 10
        temp = money / 10;
        if (temp != 0) {
            System.out.printf("%d nota(s) de 10\n", temp);
        }
        money -= temp * 10;
        // 5
        temp = money / 5;
        if (temp != 0) {
            System.out.printf("%d nota(s) de 5\n", temp);
        }
        money -= temp * 5;
        // 1
        temp = money / 1;
        if (temp != 0) {
            System.out.printf("%d nota(s) de 1\n", temp);
        }
    }
}