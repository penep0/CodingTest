import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] relations;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int minSum = Integer.MAX_VALUE;
        int result = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        relations = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relations[a][b] = 1;
            relations[b][a] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (minSum > getRelations(i)) {
                minSum = getRelations(i);
                result = i;
            }
        }
        System.out.println(result);
    }

    public static int getRelations(int a) {
        boolean[] visited = new boolean[N + 1];
        visited[a] = true;
        int[] res = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i = 1; i <= N; i++) {
                if (relations[curr][i] == 1 && !visited[i]) {
                    q.add(i);
                    res[i] = res[curr] + 1;
                    visited[i] = true;
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += res[i];
        }
        return sum;
    }
}