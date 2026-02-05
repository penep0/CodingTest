import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        for(int i = n - 1; i > 0; i--) {
            int b = i;
            for(int j = i; j >= 1; j /= 10) {
                b += j % 10;
            }
            if(b == n) {
                result = i;
            }
        }
        System.out.println(result);
    }
}