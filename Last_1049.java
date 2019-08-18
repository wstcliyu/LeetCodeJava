class Last_1049 {
    // Most voted solution from lee215
    public int lastStoneWeightII(int[] stones) {
        boolean[] dp = new boolean[1501];
        dp[0] = true;
        int sum = 0;
        for (int a : stones) {
            sum += a;
            for (int i = sum; i >= a; i--) {
                dp[i] |= dp[i - a];
            }
        }
        for (int i = sum/2; i > 0; i--) {
            if (dp[i]) return sum - i - i;
        }
        return 0;
    }
}