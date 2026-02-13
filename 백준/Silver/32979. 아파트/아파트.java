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
        int T = Integer.parseInt(br.readLine());
        int[] count = new int[T];
        Deque<Integer> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            deque.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            count[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < T; i++) {
            for (int j = 1; j < count[i]; j++) {
                deque.add(deque.poll());
            }
            System.out.print(deque.peek() + " ");
        }
    }
}