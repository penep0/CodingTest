import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] check;
    static StringBuilder[] sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            check = new boolean[10000];
            sb = new StringBuilder[10000];
            for (int j = 0; j < 10000; j++) {
                sb[j] = new StringBuilder();
            }
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bfs(start, end);
            System.out.println(sb[end].toString());
        }
    }

    public static void bfs(int start, int end) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        check[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            int nextD = D(now);
            if (!check[nextD]) {
                queue.add(nextD);
                sb[nextD].append(sb[now]).append("D");
                check[nextD] = true;
                if (nextD == end) break;
            }

            int nextS = S(now);
            if (!check[nextS]) {
                queue.add(nextS);
                sb[nextS].append(sb[now]).append("S");
                check[nextS] = true;
                if (nextS == end) break;
            }

            int nextL = L(now);
            if (!check[nextL]) {
                queue.add(nextL);
                sb[nextL].append(sb[now]).append("L");
                check[nextL] = true;
                if (nextL == end) break;
            }

            int nextR = R(now);
            if (!check[nextR]) {
                queue.add(nextR);
                sb[nextR].append(sb[now]).append("R");
                check[nextR] = true;
                if (nextR == end) break;
            }
        }
    }

    public static int D(int point) {
        return point * 2 % 10000;
    }

    public static int S(int point) {
        return point == 0 ? 9999 : point - 1;
    }

    public static int L(int point) {
        return point % 1000 * 10 + point / 1000;
    }

    public static int R(int point) {
        return point % 10 * 1000 + point / 10;
    }
}