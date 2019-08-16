class Check_1150 {
    // My first solution
    public boolean isMajorityElement(int[] nums, int target) {
        int l = 0, r = nums.length;
        int left = l;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < target) l = m + 1;
            else r = m;
        }
        if (r == nums.length || nums[r] != target) return false;
        else left = r;
        
        l = 0;
        r = nums.length;
        int right = r;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] <= target) l = m + 1;
            else r = m;
        }
        right = r;
        return (right - left) > nums.length / 2;
    }
}