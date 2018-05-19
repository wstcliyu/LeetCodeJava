import java.util.Arrays;

public class SetMismatch_645 {
    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] result = new int[2];
        for (int i=0; i<n; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val-1] > 0)
                nums[val-1] *= -1;
            else
                result[0] = val;
        }
        for (int i=0; i<n; i++) {
            if (nums[i] > 0)
                result[1] = i+1;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] testNums = {1,3,3,4,5};
        System.out.println(Arrays.toString(findErrorNums(testNums)));
    }
}
