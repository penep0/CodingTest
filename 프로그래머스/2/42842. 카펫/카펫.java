class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i = 1; i <= yellow / 2 + 1; i++) {
            if (yellow % i != 0) continue;
            int h = yellow / i;
            
            int count = (i + 2) * 2 + h * 2;
            if (count == brown) {
                answer[0] = i + 2;
                answer[1] = h + 2;
            }
        }
        return answer;
    }
}