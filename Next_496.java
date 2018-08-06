import java.util.ArrayDeque;
import java.util.HashMap;

public class Next_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // https://leetcode.com/problems/next-greater-element-i/discuss/97595/Java-10-lines-linear-time-complexity-O(n)-with-explanation
        // Refer to the most voted solution
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for (int num : nums1) {
            while (!st.isEmpty() && st.peek() < num)
                map.put(st.poll(), num);
            st.push(num);
        }
        for (int i=0; i<nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
}
