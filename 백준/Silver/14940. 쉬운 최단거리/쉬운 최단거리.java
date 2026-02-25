import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[][] grid;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        int[][] answer = new int[N][M];
        int sx = -1, sy = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 2) { sx = i; sy = j; }
                answer[i][j] = (grid[i][j] == 1 ? -1 : 0);
            }
        }

        bfs(sx, sy, answer);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bfs(int x, int y, int[][] answer) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] dir : directions) {
                int newX = curX + dir[0];
                int newY = curY + dir[1];

                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                    if (grid[newX][newY] == 1 && answer[newX][newY] == -1) {
                        answer[newX][newY] = answer[curX][curY] + 1;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
    }
}
