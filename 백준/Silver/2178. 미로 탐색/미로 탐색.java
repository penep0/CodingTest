import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] maze = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                if(line.charAt(j) == '1') {
                    maze[i][j] = 1;
                }else {
                    maze[i][j] = 0;
                }
            }
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if(x == N - 1 && y == M - 1) {
                System.out.println(maze[x][y]);
                break;
            }

            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for(int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if(newX >= 0 && newX < N && newY >= 0 && newY < M) {
                    if(maze[newX][newY] == 1 && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        maze[newX][newY] = maze[x][y] + 1;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
    }
}
