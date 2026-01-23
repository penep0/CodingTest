import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            heap.add(scoville[i]);
        }
        int sum = 0;
        
        while (heap.size() >= 1) {
            sum = heap.poll();
            
            if(sum < K) {
                if (heap.isEmpty()) return -1;
                sum += heap.poll() * 2;
                answer++;
                heap.add(sum);
            } else {
                break;
            }
        }
        
        return answer;
    }
}