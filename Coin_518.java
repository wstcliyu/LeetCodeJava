class Coin_518 {
	// Knapsack problem (1D DP)
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                dp[i] += dp[i - coin];
        return dp[amount];
    }




    // 2D DP
    /*
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = coins[i - 1]; j <= amount; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
            }
        }
        return dp[coins.length][amount];
    }
    */



    // I try to write dfs with memoization (TLE)
    /*
    public int change(int amount, int[] coins) {
        if (amount == 0) return 1;
        if (coins.length == 0) return 0;
        int[][] dp = new int[amount + 1][coins.length];
        Arrays.fill(dp[0], 1);
        Arrays.sort(coins);
        return dfs(amount, coins, dp, 0);
    }
    
    private int dfs(int amount, int[] coins, int[][] dp, int start) {
        if (dp[amount][start] > 0)
            return dp[amount][start];
        int res = 0;
        for (int i = start; i < coins.length && amount >= coins[i]; i++) {
            res += dfs(amount - coins[i], coins, dp, i);
        }
        
        dp[amount][start] = res;
        return res;
    }
    */
}