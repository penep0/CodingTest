import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {truck_weights[0], 1});
        int truck = 1;
        int sum = truck_weights[0];
        
        while (!deque.isEmpty()) {
            answer++;
            int[] now = deque.peek();
            if (answer - now[1] == bridge_length) {
                int[] poll = deque.poll();
                sum -= poll[0];
            }
            if (truck < truck_weights.length) {
                if (sum + truck_weights[truck] <= weight) {
                    deque.add(new int[]{truck_weights[truck], answer});
                    sum += truck_weights[truck];
                    truck++;
                }
            }
        }
        
        return answer;
    }
}
