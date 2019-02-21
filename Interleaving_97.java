class Interleaving_97 {
	// Standard solution #3: 2D DP
	// Time: O(m*n)
	// Space: O(m*n).
	public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }


    // Standard solution #4: 1D DP
    // Time: O(m*n)
    // Space: O(n)
    /*
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        boolean dp[] = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s2.length()];
    } 
    */


	// My first solution
	// Similar with standard solution #1: Brute Force
	// Time: O(2^{m+n}). m is the length of s1, n is the length of s2.
	// Space: O(m+n). The size of stack for recursive calls can go upto m+n.
	/*
	public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length() ) return false;
        return helper(s1, 0, s2, 0, s3, 0);
    }

    private boolean helper(String s1, int p1, String s2, int p2, String s3, int p3) {
    	if (p3 == s3.length()) return true;
    	char c1 = p1 < s1.length() ? s1.charAt(p1) : 0;
    	char c2 = p2 < s2.length() ? s2.charAt(p2) : 0;
    	char c3 = p3 < s3.length() ? s3.charAt(p3) : 0;
    	if (c3 != c1 && c3 != c2) 
    		return false;
    	else if (c1 == c2) 
    		return helper(s1, p1+1, s2, p2, s3, p3+1) || helper(s1, p1, s2, p2+1, s3, p3+1);
    	else if (c3 == c1)
    		return helper(s1, p1+1, s2, p2, s3, p3+1);
    	else
    		return helper(s1, p1, s2, p2+1, s3, p3+1);
    }
    */
}