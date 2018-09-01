public class Guess_375 {

    // https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84764/Simple-DP-solution-with-explanation~~

    // Most voted solution using recursion
    /*
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return helper(dp, 1, n);
    }
    private int helper(int[][] dp, int s, int e) {
        if (s >= e)
            return 0;
        if (dp[s][e] > 0)
            return dp[s][e];
        int res = Integer.MAX_VALUE;
        for (int i=s; i<=e; i++) {
            int tmp = i + Math.max(helper(dp, s, i-1), helper(dp, i+1, e));
            res = Math.min(res, tmp);
        }
        dp[s][e] = res;
        return res;
    }
    */


    // Bottom up solution
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for (int e=2; e<=n; e++) {
            for (int s=e-1; s>0; s--) {
                int res = Integer.MAX_VALUE;
                for (int i=s; i<=e; i++) {
                    int tmp = i + Math.max(dp[s][i-1], dp[i+1][e]);
                    res = Math.min(res, tmp);
                }
                dp[s][e] = res;
            }
        }
        return dp[1][n];
    }
}
