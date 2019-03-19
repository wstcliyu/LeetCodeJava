public class Search_35 {
    // My updated solution
    /*
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) 
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    */




    public static int searchInsert(int[] nums, int target) {
        // int p = Arrays.binarySearch(nums, target);
        // return p < 0 ? - p - 1 : p;
        int n = nums.length;
        int left = 0, right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target) 
                left = mid + 1;
            else if (mid == 0 || nums[mid - 1] < target)
                return mid;
            else
                right = mid;
        }
        return left;
    }

    public static void main (String args[]) {
        int[] testNums = {1,3,5,6};
        int testTarget = 0;
        System.out.println(searchInsert(testNums,testTarget));
    }
}
