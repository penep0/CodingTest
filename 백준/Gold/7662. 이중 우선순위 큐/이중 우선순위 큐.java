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
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (command.equals("I")) {
                    tm.put(num, tm.getOrDefault(num, 0) + 1);
                } else {
                    if (tm.isEmpty()) continue;
                    int target = 0;
                    if (num == 1) target = tm.lastKey();
                    if (num == -1) target = tm.firstKey();

                    if (tm.get(target) == 1) tm.remove(target);
                    else tm.put(target, tm.getOrDefault(target, 0) - 1);
                }
            }
            if (tm.isEmpty()) System.out.println("EMPTY");
            else System.out.println(tm.lastKey() + " " + tm.firstKey());
        }
    }
}