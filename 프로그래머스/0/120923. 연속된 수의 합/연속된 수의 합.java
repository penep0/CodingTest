class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        for (int i = -(total + num); i <= total + num; i++) {
            int count = 0;
            for (int j = i; j < i + num; j++) {
                count += j;
            }
            if (count == total) {
                int c = i;
                for (int j = 0; j < num; j++) {
                    answer[j] = c;
                    c++;
                }
            }
        }
        return answer;
    }
}