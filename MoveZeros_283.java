import java.util.Arrays;

public class MoveZeros_283 {
    // My updated solution
    public static void moveZeroes(int[] nums) {
        int write = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[write++] = nums[i];
        }
        while (write < nums.length) nums[write++] = 0;
    }

    /*
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int countNonZero = 0;
        for (int i=0; i<n; i++) {
            if (nums[i] != 0) {
                nums[countNonZero] = nums[i];
                if (i != countNonZero)
                    nums[i] = 0;
                countNonZero++;
            }
        }
    }
    */


    public static void main (String args[]) {
        int[] testNums = {1};
        moveZeroes(testNums);
        System.out.println(Arrays.toString(testNums));
    }
}
