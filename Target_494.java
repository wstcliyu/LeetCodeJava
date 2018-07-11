public class Target_494 {
    // Good Submission
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

    // My first solution with recursion
    // Time O(2^n) Space?
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
