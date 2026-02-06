import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            String function = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            StringBuilder sb = new StringBuilder();
            boolean isR = false;
            boolean error = false;
            String arrLine = br.readLine();
            String inside = arrLine.substring(1, arrLine.length() - 1);

            if (n > 0) {
                st = new StringTokenizer(inside, ",");
                while (st.hasMoreTokens()) {
                    deque.addLast(Integer.parseInt(st.nextToken()));
                }
            }

            for (int j = 0; j < function.length(); j++) {
                char command = function.charAt(j);
                if (command == 'R') {
                    isR = !isR;
                } else {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }

                    if (isR) deque.pollLast();
                    else deque.pollFirst();
                }
            }
            if (!error) {
                sb.append('[');
                int count = deque.size();
                for (int j = 0; j < count; j++) {
                    sb.append(isR ? deque.pollLast() : deque.pollFirst());
                    if (j != count - 1) sb.append(',');
                }
                sb.append(']');
            } else {
                sb.append("error");
            }
            System.out.println(sb);
        }
    }
}