import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static int[][] grid;
    static int answer = 0;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, grid[i][j], visited);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int x, int y, int count, int sum, boolean[][] visited) {
        if (count == 4) {
            answer = Math.max(sum, answer);
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, count + 1, sum + grid[nx][ny], visited);
                if (count == 2) {
                    dfs(x, y, count + 1, sum + grid[nx][ny], visited);
                }
                visited[nx][ny] = false;
            }
        }
    }
}