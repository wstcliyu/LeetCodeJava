public class Largest_747 {
    public static int dominantIndex(int[] nums) {
        int n = nums.length;
        int max = 0;
        int subMax = 0;
        int result = 0;
        for (int i=0; i<n; i++) {
            if (nums[i] > max) {
                subMax = max;
                max = nums[i];
                result = i;
            }
            else if (nums[i] > subMax)
                subMax = nums[i];
        }
        if (max < 2*subMax)
            return -1;
        else
            return result;
    }
    public static void main (String args[]) {
        int[] testNums = {0,1,2,3};
        System.out.println(dominantIndex(testNums));
    }
}
