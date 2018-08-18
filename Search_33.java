public class Search_33 {
    // https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14436/Revised-Binary-Search
    // One binary search
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < nums[r]) {
                if (target <= nums[r] && target > nums[mid])
                    l = mid + 1;
                else
                    r = mid;
            }
            else {
                if (target >= nums[l] && target < nums[mid])
                    r = mid;
                else
                    l = mid + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }
}
