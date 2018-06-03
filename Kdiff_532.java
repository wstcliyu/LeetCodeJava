import java.util.HashSet;
import java.util.HashMap;

public class Kdiff_532 {
    public static int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)
            return 0;
        /* Most voted solution use only one HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2)
                    count++;
            } else {
                if (map.containsKey(entry.getKey() + k))
                    count++;
            }
        }
        return count;
        */
        HashSet<Integer> numSet = new HashSet<>();
        HashMap<Integer,Integer> seen = new HashMap<>();
        int res = 0;
        for (int n:nums) {
            if (numSet.contains(n+k) && !seen.containsKey(n)) {
                seen.put(n, n+k);
                res++;
            }
            if (numSet.contains(n-k) && !seen.containsKey(n-k) ) {
                seen.put(n-k, n);
                res++;
            }
            numSet.add(n);
        }
        return res;
    }
}
