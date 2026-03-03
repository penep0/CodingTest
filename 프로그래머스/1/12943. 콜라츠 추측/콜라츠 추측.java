class Solution {
    public int solution(int num) {
        int answer = 0;
        long now = num;
        while (now != 1) {
            if (answer == 500) {
                answer = -1;
                break;
            }
            
            if (now % 2 == 0) {
                now /= 2;
            } else {
                now *= 3;
                now += 1;
            }
            
            answer++;
        }
        
        return answer;
    }
}