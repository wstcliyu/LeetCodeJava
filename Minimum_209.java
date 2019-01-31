import java.util.Arrays;

public class Minimum_209 {
    // Two pointers or sliding window
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = 0, sum = 0, res = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j++];
            while (sum >= s) {
                res = Math.min(res, j - i);
                sum -= nums[i++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }


    // O(n lgn) using Prefix Sums
    /*
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length, res = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++)
            sums[i + 1] = sums[i] + nums[i];
        for (int i = 0; i < n; i++) {
            int idx = Arrays.binarySearch(sums, sums[i] + s);
            idx = idx < 0 ? - idx - 1 : idx;
            if (idx <= n) res = Math.min(res, idx - i);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    */
}
