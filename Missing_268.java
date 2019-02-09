import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Missing_268 {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int pos = Math.abs(nums[i]) - 1;
            if (pos >= 0 && pos < n) {
                nums[pos] *= -1;
                if (nums[pos] == 0) nums[pos] = -n-1;
            }
        }
        for (int i = 0; i < n; i++) if (nums[i] > 0) return i + 1;
        return 0;
    }


    // Binary Search
    /*
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length;
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] > mid) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    */


    // Standard solution #3: Bit Manipulation
    /*
    public int missingNumber(int[] nums) {
        int missing = n;
        for (int i = 0; i < n; i++)
            missing ^= (nums[i] ^ i);
        return missing;
    }
    */


    // Standard solution #4: Gauss' Formula
    /*
    public int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        for (int num : nums) sum += num;
        return n * (n + 1) / 2 - sum;
    }
    */


    // Standard solution #2: HashSet
    /*
    public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }
    */


    // Standard solution #1: Sort
    /*
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        // Ensure that n is at the last index
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        // Ensure that 0 is at the first index
        else if (nums[0] != 0) {
            return 0;
        }

        // If we get here, then the missing number is on the range (0, n)
        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i-1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }

        // Array was not missing any numbers
        return -1;
    }
    */
}
