public class Integer_343 {
    // DP
    // The other method use math knowledge (split to as many 3's as possible when n is large)
    public int integerBreak(int n) {
        int[] dp = new int[59];
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++)
                dp[i] = Math.max(dp[i], (i - j) * Math.max(j, dp[j]));
        }
        return dp[n];
    }
}
