import java.util.*;

class Solution {
    char[][] a;                 // storage with padding
    boolean[][] out;            // outside-air reachable (from (0,0))
    int H, W;
    int remain;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        int h = storage.length;
        int w = storage[0].length();

        H = h + 2;
        W = w + 2;
        a = new char[H][W];
        remain = h * w;

        // init with '0' (air)
        for (int i = 0; i < H; i++) Arrays.fill(a[i], '0');

        // copy storage into padded board
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                a[i][j] = storage[i - 1].charAt(j - 1);
            }
        }

        // initial outside air marking
        recomputeOutside();

        for (String cmd : requests) {
            char target = cmd.charAt(0);

            if (cmd.length() == 1) {
                deleteExposed(target);   // only those touching outside air
            } else {
                deleteAll(target);       // all targets
            }
        }

        return remain;
    }

    // BFS from (0,0) over air cells '0'
    private void recomputeOutside() {
        out = new boolean[H][W];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        out[0][0] = true;
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if (out[nx][ny]) continue;
                if (a[nx][ny] != '0') continue;     // only flow through air
                out[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

    // delete only target cells adjacent to outside air (as of this moment)
    private void deleteExposed(char target) {
        ArrayList<int[]> toDel = new ArrayList<>();

        for (int i = 1; i < H - 1; i++) {
            for (int j = 1; j < W - 1; j++) {
                if (a[i][j] != target) continue;

                boolean exposed = false;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (out[nx][ny]) {  // IMPORTANT: outside air, not just '0'
                        exposed = true;
                        break;
                    }
                }
                if (exposed) toDel.add(new int[]{i, j});
            }
        }

        if (toDel.isEmpty()) return;

        // delete all at once (so this command doesn't chain within same scan)
        for (int[] p : toDel) {
            a[p[0]][p[1]] = '0';
            remain--;
        }

        // outside air expands after deletions
        recomputeOutside();
    }

    // delete every target cell, then recompute outside air
    private void deleteAll(char target) {
        boolean changed = false;

        for (int i = 1; i < H - 1; i++) {
            for (int j = 1; j < W - 1; j++) {
                if (a[i][j] == target) {
                    a[i][j] = '0';
                    remain--;
                    changed = true;
                }
            }
        }

        if (changed) recomputeOutside();
    }
}