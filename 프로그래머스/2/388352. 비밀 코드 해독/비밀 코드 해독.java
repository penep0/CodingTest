import java.util.*;

class Solution {
    int answer = 0;

    public int solution(int n, int[][] q, int[] ans) {
        int[] code = new int[5];
        select(0, 1, n, code, q, ans);
        return answer;
    }

    private void select(int idx, int start, int n, int[] code, int[][] q, int[] ans) {
        if (idx == 5) {
            if (checkAll(code, q, ans)) answer++;
            return;
        }

        int maxStart = n - (5 - idx) + 1;

        for (int i = start; i <= maxStart; i++) {
            code[idx] = i;
            select(idx + 1, i + 1, n, code, q, ans);
        }
    }

    private boolean checkNum(int target, int[] code, int[] input) {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            int c = code[i];
            for (int j = 0; j < 5; j++) {
                if (c == input[j]) {
                    cnt++;
                    break;
                }
            }
        }
        return cnt == target;
    }

    private boolean checkAll(int[] code, int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) {
            if (!checkNum(ans[i], code, q[i])) return false;
        }
        return true;
    }
}