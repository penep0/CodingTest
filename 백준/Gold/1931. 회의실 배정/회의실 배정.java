import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        int answer = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a, b) -> {if (a[1] == b[1]) return a[0] - b[0]; else return a[1] - b[1];});

        int end = arr[0][1];

        for (int i = 1; i < n; i++) {
            if (arr[i][0] >= end) {
                end = arr[i][1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}