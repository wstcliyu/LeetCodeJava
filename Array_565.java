class Array_565 {
    // Most voted solution
    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) continue;
            int count = 0;
            for (int k = i; nums[k] != -1; count++) {
                int tmp = k;
                k = nums[k];
                nums[tmp] = -1; // Mark as visited
            }
            res = Math.max(res, count);
        }
        return res;
    }
}