import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        answer = bfs(maps);
        return answer;
    }
    
    public int bfs(int[][] maps) {
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[][] check = new boolean[maps.length][maps[0].length];
        int[][] dist = new int[maps.length][maps[0].length];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        deque.add(new int[]{0, 0});
        check[0][0] = true;
        dist[0][0] = 1;
        while (!deque.isEmpty()) {
            int[] now = deque.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < maps.length && ny < maps[0].length && nx >= 0 && ny >= 0) {
                    if (maps[nx][ny] == 1 && !check[nx][ny]) {
                        deque.add(new int[]{nx, ny});
                        dist[nx][ny] += dist[now[0]][now[1]] + 1;
                        check[nx][ny] = true;
                    }
                }
            }
        }
        
        return dist[maps.length - 1][maps[0].length - 1] != 0 ? dist[maps.length - 1][maps[0].length - 1] : -1;
    }
}