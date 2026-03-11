import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        bfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append('\n');
        }

        System.out.print(sb);
    }

    static void bfs(int start) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {

                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = cur;
                    q.add(next);
                }
            }
        }
    }
}