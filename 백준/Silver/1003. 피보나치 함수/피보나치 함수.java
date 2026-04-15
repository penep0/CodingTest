import java.io.*;
import java.util.*;

public class Main {
    static Integer[][] result = new Integer[42][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        result[0][0] = 1;
        result[0][1] = 0;
        result[1][0] = 0;
        result[1][1] = 1;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            fibonachi(num);
            sb.append(result[num][0] + " " + result[num][1]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static Integer[] fibonachi(int n) {
        if(result[n][0] == null || result[n][1] == null) {
            result[n][0] = fibonachi(n-1)[0] + fibonachi(n-2)[0];
            result[n][1] = fibonachi(n-1)[1] + fibonachi(n-2)[1];
        }
        return result[n];
    }
}