import java.util.Arrays;

public class ThreeSum_16 {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            if (res == target)
                return target;
            int left = i+1, right = nums.length-1;
            while (left < right) {
                int minSum = nums[i] + nums[left] + nums[left+1];
                if (minSum > target) {
                    res = Math.abs(res - target) < Math.abs(minSum - target) ? res : minSum;
                    break;
                }
                int maxSum = nums[i] + nums[right] + nums[right-1];
                if (maxSum < target) {
                    res = Math.abs(res - target) < Math.abs(maxSum - target) ? res : maxSum;
                    break;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target)
                    left++;
                else if (sum > target)
                    right--;
                else
                    return target;
                res = Math.abs(res-target)<Math.abs(sum-target) ? res : sum;
            }
        }
        return res;
    }
}
