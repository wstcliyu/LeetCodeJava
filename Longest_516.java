class Longest_516 {
    // https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99101/Straight-forward-Java-DP-solution
    // Most voted solution using DP
    public int longestPalindromeSubseq(String s) {
        int N = s.length();
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) dp[i][i] = 1;
        for (int d = 1; d < N; d++) {
            for (int i = 0; i + d < N; i++) {
                if (s.charAt(i) == s.charAt(i + d))
                    dp[i][i + d] = 2 + dp[i + 1][i + d - 1];
                else
                    dp[i][i + d] = Math.max(dp[i + 1][i + d], dp[i][i + d - 1]);
            }
        }
        return dp[0][N - 1];
    }





    // Most voted solution using top-down recursion with memorization
    /*
    public int longestPalindromeSubseq(String s) {
        int N = s.length();
        return helper(new int[N][N], s, 0, N - 1);
    }

    private int helper(int[][] dp, String s, int l, int r) {
        if (l > r || dp[l][r] > 0) 
            return dp[l][r];
        if (l == r)
            return 1;
        if (s.charAt(l) == s.charAt(r))
            dp[l][r] = 2 + helper(dp, s, l + 1, r - 1);
        else
            dp[l][r] = Math.max(helper(dp, s, l + 1, r), helper(dp, s, l, r - 1));
        return dp[l][r];
    }
    */
}