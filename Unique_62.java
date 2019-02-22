import java.util.Arrays;

public class Unique_62 {
    // 2D DP
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
        return dp[m - 1][n - 1];
    }


    // 1D DP
    /*
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {          
            for (int j = 1; j < n; j++) {
                dp[j] += dp[Math.max(0, j - 1)];
            }
        }   
        return dp[n - 1];
    }
    */
}
