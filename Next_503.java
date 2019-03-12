import java.util.Arrays;
import java.util.ArrayDeque;

public class Next_503 {
	// My first solution: two pass
	// Similar with most voted 
	// https://leetcode.com/problems/next-greater-element-ii/discuss/98273/Java-10-lines-and-C%2B%2B-12-lines-linear-time-complexity-O(n)-with-explanation
	public int[] nextGreaterElements(int[] nums) {
        if (nums.length == 0) return new int[0];
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.getLast()]) {
                res[stack.removeLast()] = nums[i];
            }
            stack.addLast(i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.getLast()]) {
                res[stack.removeLast()] = nums[i];
            }
        }
        
        return res;
    }
}