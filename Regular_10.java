class Regular_10 {
    // Standard solution #1: Recursion
    /*
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
    */



    // Standard solution #2: DP
    // Bottom-up version
    /*
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        int M = text.length();
        int N = pattern.length();
        boolean[][] dp = new boolean[M + 1][N + 1];
        dp[M][N] = true;
        for (int i = M; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                boolean first_match = (i < M && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
                if (j + 1 < N && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (first_match && dp[i + 1][j]);
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
    */
    


    // Top-down version
    public boolean isMatch(String text, String pattern) {
        // if (pattern.isEmpty()) return text.isEmpty();
        int M = text.length();
        int N = pattern.length();
        Boolean[][] memo = new Boolean[M + 1][N + 1];
        memo[M][N] = true;
        return isMatch(memo, 0, 0, text.toCharArray(), pattern.toCharArray());
    }

    private boolean isMatch(Boolean[][] memo, int i, int j, char[] text, char[] pattern) {
        if (j == pattern.length) 
            memo[i][j] = i == text.length;
        else if (memo[i][j] != null) 
            return memo[i][j];
        else {
            boolean first_match = (i < text.length && (pattern[j] == text[i] || pattern[j] == '.'));
            if (j + 1 < pattern.length && pattern[j + 1] == '*') {
                memo[i][j] = isMatch(memo, i, j + 2, text, pattern) || (first_match && isMatch(memo, i + 1, j, text, pattern));
            } else {
                memo[i][j] = first_match && isMatch(memo, i + 1, j + 1, text, pattern);
            }
        }
        
        return memo[i][j];
    }
}