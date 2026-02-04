import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] check;
    static int n;
    static char[][] grid;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int answerA = 0;
        int answerB = 0;
        grid = new char[n][n];
        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) {
                    bfs(i, j);
                    answerA++;
                }
            }
        }

        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) {
                    bfsJ(i, j);
                    answerB++;
                }
            }
        }

        System.out.println(answerA + " " + answerB);
    }

    public static void bfs(int x, int y) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x, y});
        check[x][y] = true;
        while (!deque.isEmpty()) {
            int[] now = deque.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !check[nx][ny]) {
                    if (grid[now[0]][now[1]] == grid[nx][ny]) {
                        deque.add(new int[]{nx, ny});
                        check[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void bfsJ(int x, int y) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x, y});
        check[x][y] = true;
        while (!deque.isEmpty()) {
            int[] now = deque.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !check[nx][ny]) {
                    if (grid[now[0]][now[1]] == 'G' && grid[nx][ny] == 'R') {
                        deque.add(new int[]{nx, ny});
                        check[nx][ny] = true;
                    } else if (grid[now[0]][now[1]] == 'R' && grid[nx][ny] == 'G') {
                        deque.add(new int[]{nx, ny});
                        check[nx][ny] = true;
                    } else if (grid[now[0]][now[1]] == grid[nx][ny]) {
                        deque.add(new int[]{nx, ny});
                        check[nx][ny] = true;
                    }
                }
            }
        }
    }
}