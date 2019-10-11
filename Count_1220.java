class Count_1220 {
    // My solution: DP
    public int countVowelPermutation(int n) {
        final int MOD = 1_000_000_007;
        int[][] dp = new int[n][5];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < n - 1; i++) {
            dp[i + 1][0] = ((dp[i][1] + dp[i][2]) % MOD + dp[i][4]) % MOD;
            dp[i + 1][1] = (dp[i][0] + dp[i][2]) % MOD;
            dp[i + 1][2] = (dp[i][1] + dp[i][3]) % MOD;
            dp[i + 1][3] = dp[i][2] % MOD;
            dp[i + 1][4] = (dp[i][2] + dp[i][3]) % MOD;
        }
        int res = 0;
        for (int i = 0; i < 5; i++) {
            res = (res + dp[n - 1][i]) % MOD;
        }
        return res;
    }
}