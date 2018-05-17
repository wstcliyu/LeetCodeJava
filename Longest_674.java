public class Longest_674 {
    public static int findLengthOfLCIS(int[] nums) {
        /* Standard solution, same thought as mine, but organized much better
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
        */
        int n = nums.length;
        int left = 0, right = 0, result = 0;
        while(right<n){
            if (right>0 && nums[right] <= nums[right-1])
                left = right;
            result = Math.max(right - left + 1, result);
            right++;
        }
        return result;
    }
    public static void main (String args[]) {
        int[] testNums = {1,3,5,4,7};
        System.out.println(findLengthOfLCIS(testNums));
    }
}
