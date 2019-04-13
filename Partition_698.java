import java.util.Arrays;

class Partition_698 {
    // My first solution (similar with Matchsticks_473)
    // First sort the array in reverse order, then DFS
    // Same as standard solution #1: Search by constructing subset sums
    // Time: O(k^N), Space: O(k) ??? I am not sure
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        Arrays.sort(nums);
        return dfs(nums, new int[k], sum / k, nums.length - 1);
    }
    
    private boolean dfs(int[] nums, int[] group, int target, int idx) {
        if (idx < 0) return true;
        
        for (int i = 0; i < group.length; i++) {
            if (group[i] + nums[idx] > target) continue;
            group[i] += nums[idx];
            if (dfs(nums, group, target, idx - 1)) return true;
            group[i] -= nums[idx];
            if (group[i] == 0) return false; // prune branch
        }
        
        return false;
    }




    // Most voted solution using DFS
    /*
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        return dfs(nums, sum / k, new boolean[nums.length], 0, 0, k);
    }
    
    private boolean dfs(int[] nums, int target, boolean[] visited, int cur, int start, int remain) {
        if (remain == 1) return true;
        if (cur == target) return dfs(nums, target, visited, 0, 0, remain - 1);
        for (int i = start; i < nums.length; i++) {
            if (!visited[i] && cur + nums[i] <= target) {
                visited[i] = true;
                if (dfs(nums, target, visited, cur + nums[i], i + 1, remain)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
    */




    // Standard solution #2: Top-down DP
    // Time: O(N * 2^N), Space: O(2^N)
    /*
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        Arrays.sort(nums);
        Boolean[] memo = new Boolean[1 << nums.length];
        memo[(1 << nums.length) - 1] = true; // Pay attention to the parenthese here
        return search(nums, memo, sum / k, 0, sum);
    }
    
    private boolean search(int[] nums, Boolean[] memo, int target, int used, int todo) {
        if (memo[used] != null) return memo[used] == true;
        memo[used] = false;
        for (int i = 0; i < nums.length && nums[i] <= (todo - 1) % target + 1; i++) {
            int future = used | (1 << i);
            if (future != used && search(nums, memo, target, future, todo - nums[i])) {
                memo[used] = true;
                break;
            }
        }
        return memo[used] == true;
    }
    */




    // Standard solution #2: Bottom-up DP
    // Slower than Top-down DP
    // Time: O(N * 2^N), Space: O(2^N)
    /*
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        Arrays.sort(nums);
        
        int N = nums.length, target = sum / k;
        int[] total = new int[1 << N];
        boolean[] dp = new boolean[1 << N];
        dp[0] = true;
        for (int used = 0; used < (1 << N); used++) {
            if (!dp[used]) continue;
            for (int i = 0; i < N && nums[i] <= target - total[used]; i++) {
                int future = used | (1 << i);
                if (future != used) {
                    dp[future] = true;
                    total[future] = (total[used] + nums[i]) % target;
                }
            }
        }
        
        return dp[(1 << nums.length) - 1];
    }
    */
}