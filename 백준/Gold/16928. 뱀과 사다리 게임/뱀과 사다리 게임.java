import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] board = new int[101];
    static boolean[] check = new boolean[101];
    static int[] dist = new int[101];
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        bfs();

        System.out.println(dist[100]);
    }

    public static void bfs() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        check[1] = true;
        dist[1] = 0;

        while (!deque.isEmpty()) {
            int position = deque.poll();

            for (int i = 1; i <= 6; i++) {
                int nPosition = position + i;
                if (nPosition > 100) continue;
                if (board[nPosition] != 0) {
                    nPosition = board[nPosition];
                }
                if (!check[nPosition]) {
                    dist[nPosition] = dist[position] + 1;
                    deque.add(nPosition);
                    check[nPosition] = true;
                }
            }
        }

    }
}