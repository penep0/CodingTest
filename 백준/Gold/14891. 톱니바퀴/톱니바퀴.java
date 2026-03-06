import java.io.*;
import java.util.*;

public class Main {
    static int[][] list = new int[4][8];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                list[i][j] = s.charAt(j) - '0';
            }
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gear = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            working(gear, direction);
        }

        for (int i = 0; i < 4; i++) {
            answer += list[i][0] * (1 << i);
        }

        System.out.println(answer);
    }

    public static void working(int point, int direction) {
        int[] rotate = new int[4];
        rotate[point] = direction;

        for (int i = point; i > 0; i--) {
            if (list[i][6] != list[i - 1][2]) {
                rotate[i - 1] = -rotate[i];
            } else {
                break;
            }
        }

        for (int i = point; i < 3; i++) {
            if (list[i][2] != list[i + 1][6]) {
                rotate[i + 1] = -rotate[i];
            } else {
                break;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (rotate[i] != 0) {
                move(i, rotate[i]);
            }
        }
    }

    public static void move(int point, int direction) {
        if (direction == 1) {
            int temp = list[point][7];
            for (int i = 7; i > 0; i--) {
                list[point][i] = list[point][i - 1];
            }
            list[point][0] = temp;
        } else { 
            int temp = list[point][0];
            for (int i = 0; i < 7; i++) {
                list[point][i] = list[point][i + 1];
            }
            list[point][7] = temp;
        }
    }
}