public class House_213 {
    // Similar with the most voted solution
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        if (len == 1)
            return nums[0];
        // Cannot rob two adjacent houses == Either avoid ith house or avoid (i+1)th house (Any two adjacent houses)
        // The solution is simply the larger of two cases with consecutive houses
        // Hence, the following solution chose i = n and i + 1 = 0 for simpler coding.
        // But, you can choose whichever two consecutive ones.
        return Math.max(rob(nums, 0, len-2), rob(nums, 1, len-1));
    }
    private int rob(int[] nums, int lo, int hi) {
        int len = hi - lo;
        int[] steal = new int[len+1];
        int[] avoid = new int[len+1];
        steal[0] = nums[lo];
        for (int i=lo+1; i<=hi; i++) {
            steal[i-lo] = nums[i] + avoid[i-lo-1];
            avoid[i-lo] = Math.max(steal[i-lo-1], avoid[i-lo-1]);
        }
        return Math.max(steal[len], avoid[len]);
    }


    // Most voted solution
    /*
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] num, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + num[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }
    */
}
