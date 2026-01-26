import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] check;
    static int N;
    static int M;
    static int[] numbers;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N + 1];
        numbers = new int[N + 1];

        find(0);
    }

    public static void find(int position) {
        if (position == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
        }
        for (int i = 1; i <= N; i++) {
            if (!check[i]) {
                check[i] = true;
                numbers[position] = i;
                find(position + 1);
                check[i] = false;
            }
        }
    }

}