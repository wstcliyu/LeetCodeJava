public class Delete_583 {
    // Standard solution #5 turns the following solutions to 1D DP

    // My solution using 2D DP (similar with standard solution #4)
    // dp[i][j] denotes the steps needed for word1[i:] and word2[j:]
    // If i == word1.length() || j == word2.length(), it means empty substring
    /*
    public int minDistance(String word1, String word2) {
        int R = word1.length(), C = word2.length();
        int[][] dp = new int[R + 1][C + 1];
        
        for (int i = 0; i <= R; i++) dp[i][C] = R - i;
        for (int j = 0; j <= C; j++) dp[R][j] = C - j;
        
        for (int i = R - 1; i >= 0; i--) {
            for (int j = C - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j))
                    dp[i][j] = dp[i + 1][j + 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        
        return dp[0][0];
    }
    */



    
    // Standard solution #4
    // Similar to Edit_72
    public int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = i + j;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }



    // Standard solution #3
    // sim[i][j] denotes the number of same characters between word1[:i] and word2[:j]
    /*
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] sim = new int[m+1][n+1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                sim[i+1][j+1] = Math.max(sim[i+1][j], sim[i][j+1]);
                if (word1.charAt(i) == word2.charAt(j))
                    sim[i+1][j+1] = Math.max(sim[i][j]+1, sim[i+1][j+1]);
            }
        }
        return m + n - sim[m][n] * 2;
    }
    */
}