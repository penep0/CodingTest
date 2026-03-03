import java.util.*;

class Solution {
    static final int MAX = 102;
    static int[][] board = new int[MAX][MAX];
    static int[][] dist = new int[MAX][MAX];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    int answer = 0;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        int maxX = 0;
        int minX = 50;
        
        int maxY = 0;
        int minY = 50;
        
        for (int i = 0; i < rectangle.length; i++) {
            if (rectangle[i][0] < minX) minX = rectangle[i][0];
            if (rectangle[i][1] < minY) minY = rectangle[i][1];
            if (rectangle[i][2] >= maxX) maxX = rectangle[i][2];
            if (rectangle[i][3] >= maxY) maxY = rectangle[i][3];
        }
        
        for (int i = 0; i < rectangle.length; i++) {
            for (int x = rectangle[i][0] * 2; x <= rectangle[i][2] * 2; x++) {
                for (int y = rectangle[i][1] * 2; y <= rectangle[i][3] * 2; y++) {
                    board[x][y] = 1;
                }   
            }
        }
        
        for (int i = 0; i < rectangle.length; i++) {
            for (int x = rectangle[i][0] * 2 + 1; x < rectangle[i][2] * 2; x++) {
                for (int y = rectangle[i][1] * 2 + 1; y < rectangle[i][3] * 2; y++) {
                    board[x][y] = 0;
                }   
            }
        }
        
        bfs(characterX, characterY, itemX, itemY);
        return dist[itemX * 2][itemY * 2] / 2;
    }
    
    public void bfs(int startX, int startY, int endX, int endY) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {startX * 2, startY * 2});
        
        while (!deque.isEmpty()) {
            int[] position = deque.poll();
            int x = position[0];
            int y = position[1];
            if (x == endX * 2 && y == endY * 2) break;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0) continue;
                if (ny >= MAX || nx >= MAX ) continue;
                if (dist[nx][ny] != 0) continue;
                if (board[nx][ny] != 1) continue;
                deque.add(new int[] {nx, ny});
                dist[nx][ny] += dist[x][y] + 1;
            }
        }
    }
}