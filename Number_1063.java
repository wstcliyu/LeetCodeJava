import java.util.*;

class Number_1063 {
    // My first solution: Mono stack
    public int validSubarrays(int[] nums) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()])
                stack.pop();
            res += stack.isEmpty() ? nums.length - i : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }



    // Most voted soluion
    /*
    Intuition
    If element i is the smallest one we encountered so far, it does not form any valid subarray with previous elements. Otherwise, it forms a valid subarray starting from each previous element that is smaller.

    For this example [2, 4, 6, 8, 5, 3, 1]:

    8: forms 4 valid subarrays (starting from 2, 4, 6, and 8)
    5 forms 3 valid subarrays (2, 4, and 5)
    3 forms 2 valid subarrays (2 and 3)
    1 forms 1 valid subarray (1)
    Solution
    Maintain monotonically increased values in a stack. The size of the stack is the number of valid subarrays between the first and last element in the stack.
    */
    /*
    public int validSubarrays(int[] nums) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < stack.peek())
                stack.pop();
            stack.push(nums[i]);
            res += stack.size();
        }
        return res;
    }
    */
}