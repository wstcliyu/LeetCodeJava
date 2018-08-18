public class Search_81 {
    // https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28218/My-8ms-C++-solution-(o(logn)-on-average-o(n)-worst-case)
    // https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28194/C++-concise-log(n)-solution
    // https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28202/Neat-JAVA-solution-using-binary-search

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[mid] == nums[l] && nums[mid] == nums[r]) {
                l++;
                r--;
            }
            else if (nums[mid] <= nums[r]) {
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
        return nums[l] == target;
    }


    // My first solution
    /*
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        return searchInRange(nums, target, 0, nums.length - 1);
    }

    private boolean searchInRange(int[] nums, int target, int l, int r) {
        if (target > nums[r] && target < nums[l])
                return false;
        if (l == r)
            return nums[l] == target;
        int mid = (l + r) / 2;
        if (nums[mid] == target)
                return true;
        if (nums[mid] < nums[r]) {
            if (target <= nums[r] && target > nums[mid])
                return searchInRange(nums, target, mid + 1, r);
            else
                return searchInRange(nums, target, l, mid);
        }
        if (nums[mid] > nums[l]) {
            if (target >= nums[l] && target < nums[mid])
                return searchInRange(nums, target, l, mid);
            else
                return searchInRange(nums, target, mid + 1, r);
        }
        if (nums[mid] == nums[l] || nums[mid] == nums[r])
            return searchInRange(nums, target, l, mid) || searchInRange(nums, target, mid + 1, r);
        return false;
    }
    */
}
