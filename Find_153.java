public class Find_153 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            // mid >= l, mid < r
            // So we compare nums[mid] with nums[r]
            // Since nums[mid] == nums[l] is possible
            if (nums[mid] > nums[r])
                l = mid + 1;
            else
                r = mid;
        }
        return nums[l];
    }
}
