import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[2][N];
            int max = 0;
            int[] dpNon = new int[N];
            int[] dpUp = new int[N];
            int[] dpDown = new int[N];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < N; m++) {
                    sticker[j][m] = Integer.parseInt(st.nextToken());
                }
            }

            dpNon[0] = 0;
            dpUp[0] = sticker[0][0];
            dpDown[0] = sticker[1][0];

            for (int j = 1; j < N; j++) {
                dpNon[j] = Math.max(dpNon[j - 1], Math.max(dpUp[j - 1], dpDown[j - 1]));
                dpUp[j] = Math.max(dpNon[j - 1], dpDown[j - 1]) + sticker[0][j];
                dpDown[j] = Math.max(dpNon[j - 1], dpUp[j - 1]) + sticker[1][j];
            }

            System.out.println(Math.max(dpNon[N - 1], Math.max(dpUp[N - 1], dpDown[N - 1])));
        }
    }
}