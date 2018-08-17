import java.util.Arrays;

public class Find_34 {
    private int findLeft(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private int findRight(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] <= target)
                l = mid;
            else
                r = mid - 1;
        }
        return r;
    }

    public int[] searchRange(int[] nums, int target) {
        if (Arrays.binarySearch(nums, target) < 0)
            return new int[]{-1, -1};
        int[] res = new int[2];
        res[0] = findLeft(nums, target);
        res[1] = findRight(nums, target);
        return res;
    }

    public static void main(String[] args) {
        Find_34 test = new Find_34();
        int[] testNums = {5, 7, 7, 8, 8, 10};
        int testTarget = 8;
        int[] res = test.searchRange(testNums, testTarget);
        System.out.println(res[0] + ", " + res[1]);
    }
}
