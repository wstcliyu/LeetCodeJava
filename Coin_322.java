import java.util.Arrays;

class Coin_322 {
    // My first solution: Bottom-up DP (similar with standard solution #3)
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) 
            for (int coin : coins)
                if (coin <= i && dp[i - coin] < Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }




    // My first solution: Top-down DP (similar with standard solution #2)
    /*
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        coinChange(coins, amount, memo);
        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }
    
    private int coinChange(int[] coins, int amount, int[] memo) {
        if (amount == 0) return 0;
        if (memo[amount] != 0) return memo[amount];
        memo[amount] = Integer.MAX_VALUE;
        for (int coin : coins)
            if (coin <= amount) {
                int temp = coinChange(coins, amount - coin, memo);
                if (temp < Integer.MAX_VALUE)
                    memo[amount] = Math.min(memo[amount], 1 + temp);
            }
        
        return memo[amount]; 
    }
    */
}