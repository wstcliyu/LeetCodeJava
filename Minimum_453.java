public class Minimum_453 {
    public int minMoves(int[] nums) {
        int sum = 0;
        int minNum = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i=0; i<n; i++) {
            sum += nums[i];
            if (nums[i] < minNum)
                minNum = nums[i];
        }
        return sum-minNum*n;
    }
}
