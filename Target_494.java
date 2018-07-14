public class Target_494 {
    // Most voted solution (Subset Sum)
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        for (int num : nums)
            sum += num;
        return (S > sum || (sum + S) % 2 != 0) ? 0 : helper(nums, (sum + S) / 2);
    }

    public int helper(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--)
                dp[i] += dp[i - num];
        }
        return dp[target];
    }

    // Standard solution #3 (2D DP)
    // Time O(l*n) The entire nums array is travesed 2001(constant no.: l) times. n refers to the size of nums array. l refers to the range of sum possible.
    // Space O(l*n) dp array of size l*n is used.
    /*
    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }
    */

    // Standard solution #4 (1D DP)
    // Time O(l*n) The entire nums array is travesed 2001(constant no.: l) times. n refers to the size of nums array. l refers to the range of sum possible.
    // Space O(n)
    /*
    public int findTargetSumWays(int[] nums, int S) {
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[sum + 1000] > 0) {
                    next[sum + nums[i] + 1000] += dp[sum + 1000];
                    next[sum - nums[i] + 1000] += dp[sum + 1000];
                }
            }
            dp = next;
        }
        return S > 1000 ? 0 : dp[S + 1000];
    }
    */

    // My first solution with recursion
    // Time O(2^n)
    // Space?
    /*
    public int findTargetSumWays(int[] nums, int S) {
        return helper(nums, S, nums.length-1);
    }
    private int helper(int[] nums, int S, int end) {
        if (end == 0) {
            if (nums[0] != S && nums[0] != -S)
                return 0;
            if (S == 0)
                return 2;
            else
                return 1;
        }
        return helper(nums, S+nums[end], end-1) + helper(nums, S-nums[end], end-1);
    }
    */
}
