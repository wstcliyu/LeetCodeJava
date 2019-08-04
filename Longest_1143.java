class Longest_1143 {
    // My solution: DP
    public int longestCommonSubsequence(String text1, String text2) {
        int R = text1.length();
        int C = text2.length();
        int[][] dp = new int[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[R][C];
    }
}