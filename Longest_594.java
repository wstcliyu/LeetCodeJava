import java.util.HashMap;

public class Longest_594 {
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int res = 0;
        HashMap<Integer,Integer> freq = new HashMap<>();
        /* If you require only one loop
        for (int n:nums) {
            freq.put(n, 1 + freq.getOrDefault(n,0));
            if (freq.containsKey(n+1))
                res = Math.max(res, freq.get(n)+freq.get(n+1));
            if (freq.containsKey(n-1))
                res = Math.max(res, freq.get(n)+freq.get(n-1));
        }
        return res;
        */
        for (int n:nums)
            freq.put(n, 1 + freq.getOrDefault(n,0));
        for (int k:freq.keySet()) {
            if (freq.containsKey(k+1))
                res = Math.max(res, freq.get(k)+freq.get(k+1));
        }
        return res;
    }
}
