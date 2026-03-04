import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;          
            next[i] = (i == n - 1) ? -1 : i + 1;
        }

        Deque<int[]> stack = new ArrayDeque<>();

        int cur = k;

        for (String c : cmd) {
            char op = c.charAt(0);

            if (op == 'U' || op == 'D') {
                int x = Integer.parseInt(c.split(" ")[1]);
                while (x-- > 0) {
                    cur = (op == 'U') ? prev[cur] : next[cur];
                }
            } else if (op == 'C') {
                stack.push(new int[]{cur, prev[cur], next[cur]});

                int p = prev[cur];
                int nx = next[cur];

                if (p != -1) next[p] = nx;
                if (nx != -1) prev[nx] = p;

                cur = (nx != -1) ? nx : p;
            } else { 
                int[] rec = stack.pop();
                int idx = rec[0];
                int p = rec[1];
                int nx = rec[2];

                if (p != -1) next[p] = idx;
                if (nx != -1) prev[nx] = idx;
                prev[idx] = p;
                next[idx] = nx;
            }
        }

        char[] ans = new char[n];
        Arrays.fill(ans, 'X');

        int head = cur;
        while (prev[head] != -1) head = prev[head];

        int t = head;
        while (t != -1) {
            ans[t] = 'O';
            t = next[t];
        }

        return new String(ans);
    }
}