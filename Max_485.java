public class Max_485 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int left = -1, result = 0;
        for (int right=0; right<n; right++) {
            if (nums[right] == 0)
                left = right;
            result = Math.max(result, right-left);
        }
        return result;
    }
    public static void main (String args[]) {
        int[] testNums = {0,0,0};
        System.out.println(findMaxConsecutiveOnes(testNums));
    }
}
