import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] result;
    static boolean[] check;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];
        arr = new int[N];
        check = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);

    }

    public static void dfs(int count) {
        if (count == M) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        int prev = -1;
        for (int i = 0; i < N; i++) {
            if (check[i]) continue;
            if (prev == arr[i]) continue;
            if (count != 0) {
                if (result[count - 1] > arr[i]) continue;
            }

            result[count] = arr[i];
            prev = arr[i];

            dfs(count + 1);
            
        }
    }
}