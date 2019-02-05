public class Unique_63 {
    // DP
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1) return 0;
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else
                    dp[i][j] = dp[Math.max(0, i - 1)][j] + dp[i][Math.max(0, j - 1)];
            }

        }
        return dp[m - 1][n - 1];
    }
}
