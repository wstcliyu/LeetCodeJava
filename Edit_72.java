class Edit_72 {
    // My first solution (refer to CLRS 15-5 for more edit distance)
    public int minDistance(String word1, String word2) {
        int M = word1.length(), N = word2.length();
        int[][] dp = new int[M+1][N+1];
        for (int i = 1; i <= M; i++)
            dp[i][0] = i;
        for (int j = 1; j <= N; j++)
            dp[0][j] = j;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else 
                    dp[i][j] = dp[i-1][j-1] + 1;
                
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + 1);
            }
        }
        return dp[M][N];
    }
}