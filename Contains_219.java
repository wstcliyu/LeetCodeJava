import java.util.HashMap;
import java.util.HashSet;

public class Contains_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2)
            return false;
        /* My first solution
        HashMap<Integer, Integer> tmp = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (i - k <= tmp.getOrDefault(nums[i], Integer.MIN_VALUE))
                return true;
            else
                tmp.put(nums[i],i);
        }
        return false;
        */
        HashSet<Integer> seen = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (seen.contains(nums[i]))
                return true;
            seen.add(nums[i]);
            if (i>=k)
                seen.remove(nums[i-k]);
        }
        return false;
    }
}
