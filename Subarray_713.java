public class Subarray_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // My solution using sliding window, same as standard solution #2
        // Edge case k == 0 or 1
        if (k <= 1)
            return 0;
        int left = 0, res = 0;
        int product = 1;
        for (int right=0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k)
                product /= nums[left++];
            res += right - left + 1;
        }
        return res;
    }
}
