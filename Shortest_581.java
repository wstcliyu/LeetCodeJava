import java.util.Arrays;

public class Shortest_581 {
    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, right = n-1;
        while (left<n-1) {
            if (nums[left] <= nums[left+1])
                left++;
            else break;
        }
        while (right>left) {
            if (nums[right-1] <= nums[right])
                right--;
            else break;
        }
        if (right == left)
            return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=left; i<=right; i++) {
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        for (int i=left; i>=0; i--) {
            if (nums[i] <= min) {
                left = i;
                break;
            }
            if (i == 0)
                left = -1;
        }
        for (int i=right; i<n; i++) {
            if (nums[i] >= max) {
                right = i;
                break;
            }
            if (i == n-1)
                right = n;
        }
        return right-left-1;
    }
    public static void main(String[] args) {
        int[] testNums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(testNums));
    }
}
