import java.util.Arrays;

public class SingleNumber_260 {
    public static int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int xor = 0;
        for (int n:nums)
            xor ^= n;
        xor = xor&(-xor);
        for (int n:nums) {
            if ((n & xor) == 0)
                res[0] ^= n;
            else res[1] ^= n;
        }
        return res;
    }
    public static void main (String args[]) {
        int[] testNums = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumber(testNums)));
    }
}
