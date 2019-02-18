import java.util.Arrays;

public class Remove_80 {
    // My updated solution using write, read, anchor
    public int removeDuplicates(int[] nums) {
        int write = 0, read = 0, anchor = 0;
        while (read < nums.length) {
            while (read < nums.length && nums[read] == nums[anchor])
                read++;
            int count = Math.min(2, read - anchor);
            for (int i = 0; i < count; i++) nums[write++] = nums[anchor];
            anchor = read;
        }
        return write;
    }


    /*
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
    */
    public static void main (String[] args) {
        int[] testNums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(testNums));
        System.out.println(Arrays.toString(testNums));
    }
}
