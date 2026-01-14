import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] cnt = new int[10];   
        int fruit = 0;
        int l = 0;
        int ans = 0;

        for (int r = 0; r < N; r++) {
            if (cnt[arr[r]] == 0) fruit++;
            cnt[arr[r]]++;
            while (fruit > 2) {
                cnt[arr[l]]--;
                if (cnt[arr[l]] == 0) fruit--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        System.out.println(ans);
    }
}