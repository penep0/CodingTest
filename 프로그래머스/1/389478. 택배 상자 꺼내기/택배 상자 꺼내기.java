class Solution {
    public int solution(int n, int w, int num) {

        int row = (num - 1) / w;
        int col;

        if (row % 2 == 0) {
            col = (num - 1) % w;
        } else {
            col = w - 1 - ((num - 1) % w);
        }

        int answer = 1;

        for (int r = row + 1; r * w < n + w; r++) {

            int idx;

            if (r % 2 == 0) {
                idx = r * w + col + 1;
            } else {
                idx = r * w + (w - 1 - col) + 1;
            }

            if (idx <= n) answer++;
        }

        return answer;
    }
}