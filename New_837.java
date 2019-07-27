class New_837 {
    // Standard solution #1: DP
    // The key recursion is f(x) = (f(x+1) + f(x+2) + ... + f(x+W)) / W
    public double new21Game(int N, int K, int W) {
        double[] dp = new double[N + W + 1];
        // dp[x] = answer when Alice has x points
        for (int i = K; i <= N; i++) {
            dp[i] = 1.0;
        }
        
        // S = dp[i + 1] + ... + dp[i + W]
        double S = Math.min(N - K + 1, W);
        for (int i = K - 1; i >= 0; i--) {
            dp[i] = S / W;
            S += dp[i] - dp[i + W];
        }
        
        return dp[0];
    }
}