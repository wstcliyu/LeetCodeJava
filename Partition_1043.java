class Partition_1043 {
    // My first solution after reading hints
    // For j = 1 .. k that keeps everything in bounds, dp[i] is the maximum of dp[i-j] + j * max(A[i-1], ..., A[i-j])
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int max = A[i - 1];
            for (int j = 1; j <= Math.min(K, i); j++) {
                max = Math.max(A[i - j], max);
                dp[i] = Math.max(dp[i], dp[i - j] + j * max);
            }
        }
        return dp[n];
    }
}