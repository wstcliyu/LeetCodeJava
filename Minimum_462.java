import java.util.Arrays;

public class Minimum_462 {
    public static int minMoves2(int[] nums) {
        /* Most voted solution also use Arrays.sort()
        Arrays.sort(nums);
        int i = 0, j = nums.length-1;
        int count = 0;
        while(i < j){
            count += nums[j]-nums[i];
            i++;
            j--;
        }
        return count;
        */
        int n = nums.length;
        Arrays.sort(nums);
        int result = 0;
        int median = (n-1)/2;
        for (int i=0; i<n; i++)
            result += i<median ? nums[median]-nums[i] : nums[i]-nums[median];
        return result;
    }
    public static void main (String args[]) {
        int[] testNums = {1,2,2};
        System.out.println(minMoves2(testNums));
    }
}
