import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Degree_697 {
    public static int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> left = new HashMap<>();
        Map<Integer,Integer> right = new HashMap<>();
        Map<Integer,Integer> count = new HashMap<>();
        int n = nums.length;
        for (int i=0; i<n; i++) {
            int key = nums[i];
            if (!left.containsKey(key))
                left.put(key, i);
            right.put(key, i);
            count.put(key, count.getOrDefault(key,0)+1);
        }
        int degree = Collections.max(count.values());
        int result = n;
        for (int val:count.keySet()) {
            if (count.get(val) == degree) {
                int temp = right.get(val) - left.get(val) + 1;
                result = Math.min(temp, result);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] testNums = {1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(testNums));
    }
}
