public class Minimum_64 {
    // DP
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int R = grid.length, C = grid[0].length;
        int[][] dp = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i == 0 && j == 0) dp[i][j] = grid[i][j];
                else
                    dp[i][j] = grid[i][j] + Math.min((i == 0 ? Integer.MAX_VALUE : dp[i-1][j]), (j == 0 ? Integer.MAX_VALUE : dp[i][j-1]));
            }
        }
        return dp[R-1][C-1];
    }
}
