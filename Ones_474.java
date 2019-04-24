class Ones_474 {
    // 0-1 Knapsack problem
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int numZeros, numOnes;
        for (String str : strs) {
            numZeros = numOnes = 0;
            for (char c : str.toCharArray()) {
                switch (c) {
                    case '0': numZeros++; break;
                    case '1': numOnes++; break;
                }
            }
            
            for (int i = m; i >= numZeros; i--) 
                for (int j = n; j >= numOnes; j--)
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - numZeros][j - numOnes]);
        }
        
        return dp[m][n];
    }
}