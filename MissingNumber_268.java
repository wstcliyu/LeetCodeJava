public class MissingNumber_268 {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        /* My Brute Force
        for (int i=0; i<n; i++) {
            int val = Math.abs(nums[i])-1;
            if (val>=0 && val<n) {
                nums[val] *= -1;
                if (nums[val] == 0)
                    nums[val] = -n-1;
            }
        }
        for (int i=0; i<n; i++) {
            if (nums[i]>=0)
                return i+1;
        }
        return 0;
        */

        /* Gauss' Formula
        int sum = 0;
        for (int i=0; i<n; i++)
            sum += nums[i];
        return n*(n+1)/2-sum;
        */
        int result = n;
        for (int i=0; i<n; i++)
            result ^= (nums[i]^i);
        return result;
    }
}
