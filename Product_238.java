import java.util.Arrays;

public class Product_238 {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // Use two variables to store the product
        // to the left and right of each element
        int left = 1, right = 1;
        for (int i=0; i<n; i++) {
            res[i] = left;
            left *= nums[i];
        }
        for (int i=n-1; i>=0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
    public static void main (String args[]) {
        int[] testNums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(testNums)));
    }
}
