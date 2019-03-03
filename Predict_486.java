public class Predict_486 {
    // My solution using (Bottom-up) DP
    public boolean PredictTheWinner(int[] nums) {
        int N = nums.length;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) dp[i][i] = nums[i];
        for (int d = 1; d < N; d++) {
            for (int i = 0; i + d < N; i++) {
                dp[i][i+d] = Math.max(nums[i] - dp[i+1][i+d], nums[i+d] - dp[i][i+d-1]);
            }
        }
        return dp[0][N-1] >= 0;
    }



    // Standard solution #3: DP
    /*
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length];
        for (int s = nums.length; s >= 0; s--) {
            for (int e = s + 1; e < nums.length; e++) {
                int a = nums[s] - dp[s + 1][e];
                int b = nums[e] - dp[s][e - 1];
                dp[s][e] = Math.max(a, b);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
    */


    // Standard solution #2: Recursion + Memorization = Top-down DP
    /*
    public boolean PredictTheWinner(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length];
        return winner(nums, 0, nums.length - 1, memo) >= 0;
    }

    public int winner(int[] nums, int s, int e, Integer[][] memo) {
        if (s == e)
            return nums[s];
        if (memo[s][e] != null)
            return memo[s][e];
        int a = nums[s] - winner(nums, s + 1, e, memo);
        int b = nums[e] - winner(nums, s, e - 1, memo);
        memo[s][e] = Math.max(a, b);
        return memo[s][e];
    }
    */
}
