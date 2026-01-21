import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] n = new int[10];
        int m = 1;
        for (int i = 0; i < 10; i++) {
            n[i] = 0;
        }

        for (int i = 0; i < 3; i++) {
            m *= Integer.parseInt(br.readLine());
        }

        while(m >= 1) {
            n[m % 10]++;
            m /= 10;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(n[i]);
        }
    }
}