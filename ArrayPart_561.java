import java.util.Arrays;

public class ArrayPart_561 {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i=0; i<nums.length; i+=2)
            result += nums[i];
        return result;
    }
    public static void main(String[] args) {
        int[] testNums = {1,4,3,2};
        System.out.println(arrayPairSum(testNums));
        System.out.println("Output should be 4");
    }
}
