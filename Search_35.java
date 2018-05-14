public class Search_35 {
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int mid;
        while (true) {
            if (target > nums[right])
                return right + 1;
            if (target < nums[left])
                return left;
            mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target) {
                right = mid - 1;
            } else left = mid + 1;
        }
    }

    public static void main (String args[]) {
        int[] testNums = {1,3,5,6};
        int testTarget = 0;
        System.out.println(searchInsert(testNums,testTarget));
    }
}
