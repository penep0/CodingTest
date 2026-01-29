import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int count = 0;
    static boolean[][] check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N][N];
        check = new boolean[N][N];
        int num = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String home = br.readLine();
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(home.charAt(j) + "");
                grid[i][j] = a;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j] && grid[i][j] == 1) {
                    list.add(dfs(new int[] {i, j}, grid));
                    count = 0;
                    num++;
                }
            }
        }
        int[] numList = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            numList[i] = list.get(i);
        }
        Arrays.sort(numList);
        System.out.println(num);
        for (int i : numList) {
            System.out.println(i);
        }
    }

    public static int dfs(int[] point, int[][] grid) {
        check[point[0]][point[1]] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int x = point[0] + dx[i];
            int y = point[1] + dy[i];
            if (x >= 0 && x < N && y >= 0 && y < N) {
                if (!check[x][y] && grid[x][y] == 1) {
                    dfs(new int[] {x, y}, grid);
                }
            }
        }
        return count;
    }
}