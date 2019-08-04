class Burst_312 {
    // Standard solution #1: DP top-down
    /*
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] new_nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            new_nums[i + 1] = nums[i];
        }
        new_nums[0] = new_nums[n - 1] = 1;
        int[][] memo = new int[n][n];
        return helper(0, n - 1, new_nums, memo);
    }
    
    private int helper(int left, int right, int[] new_nums, int[][] memo) {
        if (left + 1 >= right) return 0;
        if (memo[left][right] == 0) {
            for (int i = left + 1; i < right; i++) {
                memo[left][right] = Math.max(memo[left][right], new_nums[left] * new_nums[i] * new_nums[right] + helper(left, i, new_nums, memo) + helper(i, right, new_nums, memo));
            }
        }
        
        return memo[left][right];
    }
    */
    


    // Standard solution #2: DP bottom-up (I rewrite this solution in my way)
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] new_nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            new_nums[i + 1] = nums[i];
        }
        new_nums[0] = new_nums[n - 1] = 1;
        int[][] memo = new int[n][n];
        for (int d = 2; d < n; d++) {
            for (int left = 0, right = left + d; left <= n - 3 && right < n; left++, right++) {
                for (int i = left + 1; i < right; i++) {
                    memo[left][right] = Math.max(memo[left][right], new_nums[left] * new_nums[i] * new_nums[right] + memo[left][i] + memo[i][right]);
                }
            }
        }
        return memo[0][n - 1];
    }
}