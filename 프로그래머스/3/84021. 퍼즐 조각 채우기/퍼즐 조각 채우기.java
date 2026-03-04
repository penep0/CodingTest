import java.util.*;

class Solution {
    static boolean[][] check;
    static List<List<int[]>> boardBlock = new ArrayList<>(); 
    static List<List<int[]>> tableBlock = new ArrayList<>(); 
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] game_board, int[][] table) {
        int n = game_board.length;
        boardBlock.clear();
        tableBlock.clear();

        check = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j] && table[i][j] == 1) {
                    List<int[]> raw = bfs(false, i, j, table);     
                    tableBlock.add(normalize(raw));             
                }
            }
        }

        check = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j] && game_board[i][j] == 0) {
                    List<int[]> raw = bfs(true, i, j, game_board);
                    boardBlock.add(normalize(raw));
                }
            }
        }

        boolean[] used = new boolean[tableBlock.size()];
        int answer = 0;

        for (List<int[]> hole : boardBlock) {
            for (int i = 0; i < tableBlock.size(); i++) {
                if (used[i]) continue;

                if (matchWithRotation(hole, tableBlock.get(i))) {
                    used[i] = true;
                    answer += hole.size();
                    break;
                }
            }
        }

        return answer;
    }

    public List<int[]> bfs(boolean isBoard, int startX, int startY, int[][] game) {
        Deque<int[]> deque = new ArrayDeque<>();
        List<int[]> block = new ArrayList<>();

        check[startX][startY] = true;
        deque.add(new int[]{startX, startY});
        block.add(new int[]{startX, startY});

        int target = isBoard ? 0 : 1;

        while (!deque.isEmpty()) {
            int[] point = deque.poll();

            for (int k = 0; k < 4; k++) {
                int nx = point[0] + dx[k];
                int ny = point[1] + dy[k];

                if (nx < 0 || ny < 0 || nx >= game.length || ny >= game[0].length) continue;
                if (check[nx][ny]) continue;
                if (game[nx][ny] != target) continue;

                check[nx][ny] = true;
                deque.add(new int[]{nx, ny});
                block.add(new int[]{nx, ny});
            }
        }

        return block;
    }

    private List<int[]> normalize(List<int[]> block) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (int[] p : block) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }

        List<int[]> norm = new ArrayList<>();
        for (int[] p : block) {
            norm.add(new int[]{p[0] - minX, p[1] - minY});
        }

        norm.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        return norm;
    }

    private List<int[]> rotate90(List<int[]> block) {
        List<int[]> rotated = new ArrayList<>();
        for (int[] p : block) {
            int x = p[0], y = p[1];
            rotated.add(new int[]{y, -x});
        }
        return normalize(rotated);
    }

    private boolean matchWithRotation(List<int[]> hole, List<int[]> block) {
        if (hole.size() != block.size()) return false;

        List<int[]> cur = block;
        for (int r = 0; r < 4; r++) {
            if (sameShape(hole, cur)) return true;
            cur = rotate90(cur);
        }
        return false;
    }

    private boolean sameShape(List<int[]> a, List<int[]> b) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)[0] != b.get(i)[0]) return false;
            if (a.get(i)[1] != b.get(i)[1]) return false;
        }
        return true;
    }
}