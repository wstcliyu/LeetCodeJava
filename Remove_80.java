import java.util.Arrays;

public class Remove_80 {
    public static int removeDuplicates(int[] nums) {
        int res = 1, count = 1, anchor = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[anchor++] = nums[i];
                res++;
                count = 1;
            }
            else if (count < 2) {
                nums[anchor++] = nums[i];
                res++;
                count++;
            }
        }
        return res;
    }
    public static void main (String[] args) {
        int[] testNums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(testNums));
        System.out.println(Arrays.toString(testNums));
    }
}
