import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedArr = new int[n];

        System.arraycopy(arr, 0, sortedArr, 0, n);

        Arrays.sort(sortedArr);

        int rank = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(sortedArr[i])) {
                continue;
            }
            map.put(sortedArr[i], rank);
            rank++;
        }

        for (int v : arr) sb.append(map.get(v)).append(' ');
        System.out.print(sb);
    }
}