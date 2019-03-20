class Dungeon_174 {
    // Most voted solution
    public int calculateMinimumHP(int[][] dungeon) {
        int R = dungeon.length;
        int C = dungeon[0].length;
        int[][] dp = new int[R][C];
        int need;
        for (int i = R - 1; i >= 0; i--) {
            for (int j = C - 1; j >= 0; j--) {
                if (i == R - 1 && j == C - 1) need = 1;
                else if (i == R - 1) need = dp[i][j + 1];
                else if (j == C - 1) need = dp[i + 1][j];
                else need = Math.min(dp[i][j + 1], dp[i + 1][j]);
                
                dp[i][j] = Math.max(1, need - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}