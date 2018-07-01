public class Maximum_53 {
    public static int maxSubArray(int[] nums) {
        int sum = 0, res = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            res = Math.max(res, sum);
            if (sum < 0)
                sum = 0;
        }
        return res;
        // Most voted solution
        /*
        int n = nums.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < n; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
        */

        // Second voted solution
        /*
        int maxSoFar = nums[0], maxEndingHere=nums[0];
        for (int i=1;i<nums.length;++i){
            maxEndingHere = nums[i] + Math.max(maxEndingHere, 0);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
        */
    }
    public static void main(String[] args) {
        int[] testNums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(testNums));
    }
}
