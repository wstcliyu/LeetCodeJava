import java.util.*;

public class Next_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // https://leetcode.com/problems/next-greater-element-i/discuss/97595/Java-10-lines-linear-time-complexity-O(n)-with-explanation
        // Refer to the most voted solution
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> st = new ArrayDeque<>();
        for (int num : nums2) {
            while (!st.isEmpty() && st.getLast() < num)
                map.put(st.removeLast(), num);
            st.add(num);
        }
        for (int i=0; i<nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
}
