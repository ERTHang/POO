import java.util.Scanner;

public class Ex1{

    public static int fib(int n){
        if(n == 0){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        else{
            return fib(n-1) + fib(n-2);
        }
    }

    public static void main(String[] args){
        Scanner n = new Scanner(System.in);
        int num = n.nextInt();
        int sum = 0;
        for(int i = 0; i < num; i++){
            System.out.printf("%d;\n", fib(i));
            sum += fib(i);
        }
        System.out.println(sum);
        n.close();
    }
}
