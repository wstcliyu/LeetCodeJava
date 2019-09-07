class Missing_1060 {
    // My first solution
    /*
    public int missingElement(int[] nums, int k) {
        int l = nums[0];
        int r = Integer.MAX_VALUE;
        while (l < r) {
            int m = l + (r - l) / 2;
            int p = Arrays.binarySearch(nums, m);
            if (p < 0) p = - p - 2;

            int tmp = m - nums[0] - p;
            if (tmp < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }
    */



    // Rewrite standard solution
    private int missing(int[] nums, int idx) {
        return nums[idx] - nums[0] - idx;
    }

    public int missingElement(int[] nums, int k) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (missing(nums, m) < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[r - 1] + k - missing(nums, r - 1);
    }
}