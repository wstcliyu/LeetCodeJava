class Divisor_1025 {
    // https://leetcode.com/problems/divisor-game/discuss/274566/just-return-N-2-0-(proof)
    // Just return N % 2 == 0
    
    // My solution using DP
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N + 1];
        for (int i = 2; i <= N; i++) 
            for (int x = 1; x <= i/2; x++)
                if (i % x == 0 && !dp[i - x]) {
                    dp[i] = true;
                    break;
                }
        return dp[N];
    }
}