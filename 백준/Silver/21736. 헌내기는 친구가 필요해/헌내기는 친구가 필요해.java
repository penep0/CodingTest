import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N;
    static int M;
    static int friend = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[N][M];

        int[] position = new int[2];
        char[][] campus = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = line.charAt(j);
                if (campus[i][j] == 'I') {
                    position[0] = i;
                    position[1] = j;
                }
            }
        }
        dfs(campus, position[0], position[1], visited);
        System.out.println(friend == 0 ? "TT" : friend);
    }

    public static void dfs(char[][] map, int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        if (map[x][y] == 'P') friend++;
        for (int k = 0; k < dx.length; k++) {
            int newx = x + dx[k];
            int newy = y + dy[k];
            if (newx < N && newx > -1 && newy < M && newy > -1 && !visited[newx][newy]) {
                if (map[newx][newy] != 'X') {
                    dfs(map, newx, newy, visited);
                }
            }
        }
    }
}