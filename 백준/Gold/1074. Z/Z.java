import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);
        long ans = 0;

        while (size > 1) {
            int half = size / 2;
            long block = (long) half * half;

            int q = 0;
            if (r >= half) q += 2;
            if (c >= half) q += 1;

            ans += q * block;

            if (r >= half) r -= half;
            if (c >= half) c -= half;

            size = half;
        }

        System.out.println(ans);
    }
}