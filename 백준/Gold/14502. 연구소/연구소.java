import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int M;
    static boolean[][] check;
    static int[][] virus;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        virus = new int[N][M];
        check = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                virus[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] table = virus;
        back(table, 0);

        System.out.println(max);
    }

    public static void back(int[][] table, int count) {
        if (count == 3) {
            Deque<int[]> deque = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (virus[i][j] == 2) {
                        deque.add(new int[] {i, j});
                    }
                }
            }

            int[][] countTable = new int[N][M];
            for (int i = 0; i < N; i++) countTable[i] = table[i].clone();
            check = new boolean[N][M];
            max = Math.max(count(bfs(countTable, deque)), max);
            return;

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (table[i][j] == 0) {
                    table[i][j] = 1;
                    back(table, count + 1);
                    table[i][j] = 0;
                }
            }
        }
    }

    public static int[][] bfs(int[][] table, Deque<int[]> deque) {
        while (!deque.isEmpty()) {
            int[] now = deque.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= N || ny >= M) continue;
                if (nx < 0 || ny < 0)  continue;
                if (check[nx][ny]) continue;
                if (!(table[nx][ny] == 0)) continue;
                deque.add(new int[] {nx, ny});
                table[nx][ny] = 2;
                check[nx][ny] = true;
            }
        }

        return table;
    }

    public static int count(int[][] arr) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) count++;
            }
        }
        return count;
    }
}