public class Single_540 {
    // My first solution, Time: O(n)
    /*
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int num : nums)
            res ^= num;
        return res;
    }
    */

    // Most voted solution using binary search
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (mid % 2 == 1)
                mid--;
            if (nums[mid] == nums[mid + 1])
                l += 2; // l will always be even
            else
                r = mid;
        }
        return nums[l];
    }
}
