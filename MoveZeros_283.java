import java.util.Arrays;

public class MoveZeros_283 {
    public static void moveZeroes(int[] nums) {
        /** Brutal force O(n^2) O(1)
        int n = nums.length;
        for (int i=0; i<n; i++) {
            if (nums[i] == 0) {
                int j;
                for (j = i; j < n; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
                if (j == n)
                    return;
            }
        }
        return;
        */
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
    public static void main (String args[]) {
        int[] testNums = {1};
        moveZeroes(testNums);
        System.out.println(Arrays.toString(testNums));
    }
}
