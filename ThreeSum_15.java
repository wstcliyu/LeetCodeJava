import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        final int target = 0;
        for (int i = 0; i < nums.length-2; i++) {
            if (3*nums[i] > target)
                break;
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int left = i+1, right = nums.length-1;
            // Normal two pointers
            /*
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] < target)
                    left++;
                else if (nums[left] + nums[right] + nums[i] > target)
                    right--;
                else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left-1]);
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right+1]);
                }
            }
            */

            // Binary search two pointers
            while (left < right) {
                int[] twoSumRes = TwoSum_167.twoSumHelper_167(nums, target-nums[i], left, right);
                if (twoSumRes != null) {
                    left = twoSumRes[0];
                    right = twoSumRes[1];
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left-1]);
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right+1]);
                }
                else
                    break;
            }
        }
        return res;
    }

    public static void main (String args[]) {
        int[] testNums = {0,3,0,1,1,-1,-5,-5,3,-3,-3,0};
        // int[] testNums = {1, 0, 0, 0, -1};
        List<List<Integer>> testRes = threeSum(testNums);
        for (List<Integer> i:testRes)
            System.out.println(Arrays.toString(i.toArray()));
        // System.out.println(Arrays.deepToString(threeSum(testNums).toArray()));
    }
}
