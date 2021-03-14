import java.util.Arrays;
import java.util.Stack;

public class Shortest_581 {
    // Standard Solution #4: Mono Stack
    public int findUnsortedSubarray(int[] nums) {
        Stack < Integer > stack = new Stack< Integer >();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }
    
    
    
    // Standard Solution #5: Space O(1) without stack
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

    

    // My first solution (Similar with standard solution #4 and #5)
    /*
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
    */
    public static void main(String[] args) {
        Shortest_581 test = new Shortest_581();
        int[] testNums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(test.findUnsortedSubarray(testNums));
    }
}
