import java.io.*;
import java.util.*;

public class Main {
    public static Integer[][] arr;
    public static int white = 0;
    public static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        devideAndConquer(0, 0, n);
        System.out.println(white + "\n" + blue);
        br.close();
    }

    public static void devideAndConquer(int row, int col, int size) {
        if(check(row, col, size)) {
            return;
        } else {
            int newSize = size / 2;
            devideAndConquer(row, col, newSize);
            devideAndConquer(row, col + newSize, newSize);
            devideAndConquer(row + newSize, col, newSize);
            devideAndConquer(row + newSize, col + newSize, newSize);
        }
    }

    public static boolean check(int row, int col, int size) {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(!arr[row][col].equals(arr[row + i][col + j])) {
                    return false;
                }
            }
        }
        if(arr[row][col] == 0) {
            white++;
        } else {
            blue++;
        }
        return true;
    }
}

