import java.util.Arrays;

class Solution {
    // DP
    public int knightDialer(int N) {
        final int mod = 1_000_000_007;
        int[] dp = new int[10], temp = new int[10];
        Arrays.fill(dp, 1);
        // Note: we cannot use dp = temp here, because that is shallow copy
        for (int i = 1; i < N; i++, dp = Arrays.copyOf(temp, 10)) {
            temp[0] = (dp[4] + dp[6]) % mod;
            temp[1] = (dp[6] + dp[8]) % mod;
            temp[2] = (dp[7] + dp[9]) % mod;
            temp[3] = (dp[4] + dp[8]) % mod;
            // Avoid sum overflow
            temp[4] = ((dp[0] + dp[3]) % mod + dp[9]) % mod;
            temp[6] = ((dp[0] + dp[1]) % mod + dp[7]) % mod;
            temp[7] = (dp[2] + dp[6]) % mod;
            temp[8] = (dp[1] + dp[3]) % mod;
            temp[9] = (dp[2] + dp[4]) % mod;
        }
        
        int res = 0;
        for (int num : dp) res = (res + num) % mod;
        return res;
    }
}