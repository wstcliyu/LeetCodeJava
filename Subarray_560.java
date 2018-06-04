import java.util.HashMap;

public class Subarray_560 {
    public int subarraySum(int[] nums, int k) {
        // Count the number of subarrays ending at each element
        // Use HashMap to store the frequency of sum-k
        int res = 0, sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            res += map.getOrDefault(sum-k,0);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
