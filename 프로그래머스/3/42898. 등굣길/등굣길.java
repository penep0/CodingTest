class Solution {
    private static final int MOD = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];

        // puddle 표시 (-1)
        for (int[] pud : puddles) {
            dp[pud[1] - 1][pud[0] - 1] = -1;
        }

        // 시작점이 웅덩이면 경로 0
        if (dp[0][0] == -1) return 0;

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (dp[i][j] == -1) continue;

                // 오른쪽으로 전파 (각각 독립적으로)
                if (j + 1 < m && dp[i][j + 1] != -1) {
                    dp[i][j + 1] = (dp[i][j + 1] + dp[i][j]) % MOD;
                }

                // 아래로 전파 (각각 독립적으로)
                if (i + 1 < n && dp[i + 1][j] != -1) {
                    dp[i + 1][j] = (dp[i + 1][j] + dp[i][j]) % MOD;
                }
            }
        }

        // 도착점이 웅덩이면 0
        return dp[n - 1][m - 1] == -1 ? 0 : dp[n - 1][m - 1];
    }
}