import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int w : works) {
            sum += w;
            if (w > 0) pq.offer(w);
        }

        if (sum <= n) return 0;

        while (n-- > 0) {
            int cur = pq.poll();      
            cur -= 1;
            pq.offer(cur);
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            long x = pq.poll();
            answer += x * x;
        }
        return answer;
    }
}