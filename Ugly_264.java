public class Ugly_264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int t2 = 1, t3 = 1, t5 = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(2 * dp[t2], Math.min(3 * dp[t3], 5 * dp[t5]));
            if (dp[i] == 2 * dp[t2]) t2++;
            if (dp[i] == 3 * dp[t3]) t3++;
            if (dp[i] == 5 * dp[t5]) t5++;
        }
        return dp[n];
    }
}
