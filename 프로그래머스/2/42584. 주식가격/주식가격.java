import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i = 0; i < prices.length - 1; i++) {
            while(!deque.isEmpty() && prices[deque.peek()] > prices[i]) {
                int index = deque.pop();
                answer[index] = i - index;
            }
            deque.push(i);
        }
        
        while(!deque.isEmpty()) {
            answer[deque.peek()] = prices.length - 1 - deque.pop();
        }
        return answer;
    }
}