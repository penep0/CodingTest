import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while (deque.size() > 1) {
            sb.append(deque.poll()).append(" ");
            deque.add(deque.poll());
        }

        sb.append(deque.poll());

        System.out.println(sb);
    }
}