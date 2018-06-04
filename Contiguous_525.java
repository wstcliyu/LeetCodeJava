import java.util.Arrays;
import java.util.HashMap;

public class Contiguous_525 {
    public int findMaxLength(int[] nums) {
        int count = 0, res = 0;
        /* Use HashMap
        HashMap<Integer,Integer> firstIndex = new HashMap<>();
        firstIndex.put(count,-1);
        for (int i=0; i<nums.length; i++) {
            count += (nums[i]==0) ? 1 : -1;
            if (firstIndex.containsKey(count))
                res = Math.max(res, i - firstIndex.get(count));
            else
                firstIndex.put(count, i);
        }
        return res;
        */
        // Use Array, faster than HashMap
        int n = nums.length;
        int[] firstIndex = new int[2*n+1];
        Arrays.fill(firstIndex, -123);
        firstIndex[n] = -1;
        for (int i=0; i<n; i++) {
            count += (nums[i]==0) ? 1 : -1;
            if (firstIndex[count+n] >= -1)
                res = Math.max(res, i - firstIndex[count+n]);
            else
                firstIndex[count+n] = i;
        }
        return res;
    }
}
