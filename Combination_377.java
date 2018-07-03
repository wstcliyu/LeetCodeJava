import java.util.Arrays;

public class Combination_377 {
    // This is bottom-up, slower than top-down
    // Because you need to calculate every dp[k], k from 1 to target
    /*
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int t=1; t<=target; t++) {
            for (int n:nums)
                dp[t] += n<=t ? dp[t-n] : 0;
        }
        return dp[target];
    }
    */

    // Most voted solution using DP
    // This is top-down, faster than bottom-up
    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (dp[target] != -1)
            return dp[target];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i])
                res += helper(nums, target - nums[i]);
        }
        dp[target] = res;
        return res;
    }

    // Recursive solution (Exceeds Time Limit)
    // Must use cache to store answer to sub-problem (DP)
    /*
    public static int combinationSum4(int[] nums, int target) {
        if (target == 0)
            return 1;
        int res = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] <= target)
                res += combinationSum4(nums, target-nums[i]);
        }
        return res;
    }
    */

    public static void main(String[] args) {
        int[] testNUms = {1,3,2};
        Combination_377 comb = new Combination_377();
        int res = comb.combinationSum4(testNUms,5);
        System.out.println(res);
    }
}
