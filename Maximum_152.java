public class Maximum_152 {
    // Most voted solution: DP
    public int maxProduct(int[] nums) {
        int res = nums[0];
        for (int i = 1, max = res, min = res; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            // Below is alternative method to update max and min
            /*
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            */
            res = Math.max(res, max);
        }
        return res;
    }
}
