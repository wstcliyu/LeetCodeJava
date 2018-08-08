import java.util.Arrays;

public class Longest_300 {
    // My first solution
    // dp[j] denotes the longest subsequence length ending in nums[j]
    // Time: O(n^2), Space: O(n)
    /*
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int res = 1;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int j=1; j<len; j++) {
            for (int i=0; i<j; i++) {
                if (nums[i] < nums[j])
                    dp[j] = Math.max(dp[j], 1 + dp[i]);
            }
            res = Math.max(res, dp[j]);
        }
        return res;
    }
    */


    // Most voted solution
    // What if there are duplicate element in the array?
    // https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
    // tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i]
    // We can easily prove that tails is an increasing array. Therefore it is possible to do a binary search in tails array to find the one needs update.
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] tails = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(tails, 0, size, num);
            if (i < 0)
                i = - (i + 1);
            tails[i] = num;
            if (i == size)
                size++;
        }
        return size;
    }


    // Standard Solution Approach #1 Brutal Force
    // Time Limit Exceeded
    // Time: O(2^n)
    // Space: O(n)
    /*
    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums, Integer.MIN_VALUE, 0)
    }
    private int lengthOfLIS(int[] nums, int prev, int cur) {
        if (cur == nums.length)
            return 0;
        int untaken = lengthOfLIS(nums, prev, cur + 1);
        int taken = 0;
        if (nums[cur] > prev)
            taken = 1 + lengthOfLIS(nums, nums[cur], cur + 1);
        return Math.max(untaken, taken);
    }
    */


    // Standard Solution Approach #2 Recursion with memorization
    // Memory Limit Exceeded
    // Time: O(2^n)
    // Space: O(n^2)
    /*
    public int lengthOfLIS(int[] nums) {
        int memo[][] = new int[nums.length + 1][nums.length];
        for (int[] l : memo) {
            Arrays.fill(l, -1);
        }
        return lengthofLIS(nums, -1, 0, memo);
    }
    public int lengthofLIS(int[] nums, int previndex, int curpos, int[][] memo) {
        if (curpos == nums.length) {
            return 0;
        }
        if (memo[previndex + 1][curpos] >= 0) {
            return memo[previndex + 1][curpos];
        }
        int taken = 0;
        if (previndex < 0 || nums[curpos] > nums[previndex]) {
            taken = 1 + lengthofLIS(nums, curpos, curpos + 1, memo);
        }

        int nottaken = lengthofLIS(nums, previndex, curpos + 1, memo);
        memo[previndex + 1][curpos] = Math.max(taken, nottaken);
        return memo[previndex + 1][curpos];
    }
    */
}
