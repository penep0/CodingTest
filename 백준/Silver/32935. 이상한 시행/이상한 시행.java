import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long sum = 0;
        long minVal = Long.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(st.nextToken());
            sum += num;
            minVal = Math.min(minVal, num);
        }

        System.out.println(Math.max(sum, -minVal));
    }
}