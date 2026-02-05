import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if (absA != absB) {
                return absA - absB;
            }
            return a - b;
        });

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int command = Integer.parseInt(br.readLine());
            if (command == 0) {
                if (heap.isEmpty()) System.out.println(0);
                else System.out.println(heap.poll());
            } else {
                heap.add(command);
            }
        }
    }
}