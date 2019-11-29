class Median_4 {
	// My first solution: Binary Search
	// My idea from: Kth Smallest Element in a Sorted Matrix 378, 373, 668, 719, 786
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int lo = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;
        if (m > 0) {
            lo = Math.min(lo, nums1[0]);
            hi = Math.max(hi, nums1[m - 1]);
        }
        if (n > 0) {
            lo = Math.min(lo, nums2[0]);
            hi = Math.max(hi, nums2[n - 1]);
        }
        // 1093. Statistics from a Large Sample
        // Elegant way to deal with odd or even total elements
        int k1 = (m + n + 1) / 2;
        int k2 = (m + n + 2) / 2;
        int e1 = findKthElement(nums1, nums2, k1, lo, hi);
        int e2 = findKthElement(nums1, nums2, k2, lo, hi);
        return (e1 + e2) * 0.5;
    }
    
    // Find Kth element in the sorted array merged by 2 sorted arrays
    private int findKthElement(int[] nums1, int[] nums2, int k, int lo, int hi) {
        int l = lo, r = hi;
        while (l < r) {
            int m = (l + r) / 2;
            // number of elements less than m
            // number of elements less than or equal to m
            int lt = getLt(nums1, m) + getLt(nums2, m);
            int le = getLt(nums1, m + 1) + getLt(nums2, m + 1);
            if (lt >= k) {
                r = m;
            } else if (le < k) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return r;
    }
    
    // Count how many elements in nums are less than target
    private int getLt(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int l = 0, r = nums.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }
    
}