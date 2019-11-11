class ThreeSum_259 {
    // Standard solution #3: Two pointers
    // Time: O(n^2)
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            res += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return res;
    }
    
    private int twoSumSmaller(int[] nums, int start, int target) {
        int count = 0;
        int l = start, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] < target) {
                count += r - l;
                l++;
            } else {
                r--;
            }
        }
        return count;
    }


    // Standard solution #2: Binary search
    // Time: O(n^2lgn)
    /*
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            res += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return res;
    }
    
    private int twoSumSmaller(int[] nums, int start, int target) {
        int count = 0;
        for (int i = start; i < nums.length - 1; i++) {
            int j = mybinarySearch(nums, i + 1, target - nums[i]);
            count += j - i;
        }
        return count;
    }
    
    private int mybinarySearch(int[] nums, int start, int target) {
        int l = start, r = nums.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r - 1;
    }
    */
}