import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] check;
    static int N;
    static int M;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N + 1];
        sb = new StringBuilder();
        dfs(1,0);
    }

    public static void dfs(int num, int count) {
        if (count == M) {
            System.out.println(sb);
            return;
        }

        for (int i = num; i <= N; i++) {
            if (!check[i]) {
                check[i] = true;
                sb.append(i).append(" ");
                dfs(i, count + 1);
                check[i] = false;
                sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
            }
        }
    }
}