import java.util.Arrays;

public class Partition_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        if (sum % 2 != 0)
            return false;
        int s = sum/2;
        int[] dp = new int[s + 1];
        dp[0] = 1;
        /*
        for (int n : nums) {
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n]; 
        }
        return dp[s]!=0;
        */
        for (int n : nums) {
            for (int i = s; i >= n; i--)
                dp[i] |= dp[i - n];
        }
        return dp[s]==1;
    }
    public static void main (String args[]) {
        int[] testNums = new int[100];
        Arrays.fill(testNums, 100);
        System.out.println(new Partition_416().canPartition(testNums));
    }
}
