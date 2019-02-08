public class Maximum_718 {
    // Standard solution #3: 2D DP
    // Since a common subarray of A and B must start at some A[i] and B[j],
    // let dp[i][j] be the longest common prefix of A[i:] and B[j:].
    // Whenever A[i] == B[j], we know dp[i][j] = dp[i+1][j+1] + 1.
    // Also, the answer is max(dp[i][j]) over all i, j.
    public int findLength(int[] A, int[] B) {
        int res = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
