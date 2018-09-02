import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Top_347 {
    // Most voted solution
    // Time: O(n)
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashSet<Integer>[] bucket = new HashSet[nums.length + 1];
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, 1 + freq.getOrDefault(num, 0));
        for (int key : freq.keySet()) {
            int frequency = freq.get(key);
            if (bucket[frequency] == null)
                bucket[frequency] = new HashSet<>();
            bucket[frequency].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int pos = bucket.length-1; pos>=0 && res.size()<k; pos--) {
            if (bucket[pos] != null)
                res.addAll(bucket[pos]);
        }
        return res;
    }
}
