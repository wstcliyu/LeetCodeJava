class Number_1155 {
	// My first solution
	private static final int MOD = 1_000_000_007;

    public int numRollsToTarget(int d, int f, int target) {
    	if (target > d * f || target < d) return 0;
        int[] dp = new int[target + 1];
        for (int k = 1; k <= d; k++) {
        	if (k == 1) {
        		Arrays.fill(dp, 1, 1 + Math.min(target, f), 1);
        		continue;
        	}
        	int sum = 0;
        	int maxPosssible = Math.min(target, f * k);
        	for (int i = maxPosssible - 1; i >= Math.max(k - 1, maxPosssible - f); i--) {
        		sum = (sum + dp[i]) % MOD;
        	}
        	// sum == dp[i - 1] + dp[i - 2] + ... + dp[i - f]
        	// The minimum number that can be achieved by (k - 1) dices is (k - 1)
        	for (int i = maxPosssible; i >= k; i--) {
        		dp[i] = sum;
        		sum = sum - dp[i - 1] + (i - 1 - f >= k - 1 ? dp[i - 1 - f] : 0);
        		sum = sum > 0 ? sum % MOD : (sum + MOD) % MOD;
        	}
        }
        return dp[target];
    }
}