import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][][] check;
    static int M;
    static int N;
    static int H;
    static int[][][] tomato;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] dz = {-1, 1};
    static Deque<int[]> deque = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomato = new int[N][M][H];
        check = new boolean[N][M][H];
        ArrayList<int[]> startPoint = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int a = 0; a < M; a++) {
                    tomato[j][a][i] = Integer.parseInt(st.nextToken());
                    if (tomato[j][a][i] == 1) {
                        deque.add(new int[]{j, a, i});
                        check[j][a][i] = true;
                    }
                }
            }
        }

        bfs();

        int max = 0;
        boolean isTomato = false;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int a = 0; a < M; a++) {
                    max = Math.max(tomato[j][a][i], max);
                    if (tomato[j][a][i] == 0) isTomato = true;
                }
            }
        }

        System.out.println(isTomato ? -1 : max - 1);
    }

    public static void bfs() {
        while (!deque.isEmpty()) {
            int[] point = deque.poll();

            for (int i = 0; i < dz.length; i++) {
                int nz = point[2] + dz[i];
                if (nz >= H) continue;
                if (nz < 0) continue;
                if (check[point[0]][point[1]][nz]) continue;
                if (tomato[point[0]][point[1]][nz] == 0) {
                    deque.add(new int[]{point[0], point[1], nz});
                    check[point[0]][point[1]][nz] = true;
                    tomato[point[0]][point[1]][nz] = tomato[point[0]][point[1]][point[2]] + 1;
                }
            }

            for (int j = 0; j < dx.length; j++) {
                int nx = point[0] + dx[j];
                int ny = point[1] + dy[j];
                if (nx >= N || ny >= M ) continue;
                if (nx < 0 || ny < 0 ) continue;
                if (check[nx][ny][point[2]]) continue;
                if (tomato[nx][ny][point[2]] == 0) {
                    deque.add(new int[]{nx, ny, point[2]});
                    check[nx][ny][point[2]] = true;
                    tomato[nx][ny][point[2]] = tomato[point[0]][point[1]][point[2]] + 1;
                }
            }
        }
    }
}