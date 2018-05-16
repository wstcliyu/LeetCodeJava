public class FindPivot_724 {
    public static int pivotIndex(int[] nums) {
        // Standard solution, better than mine, O(n) O(1)
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;

        /* My solution, O(n) O(n)
        int n = nums.length;
        int[] sums = new int[n+1];
        sums[0] = 0;
        for (int i=1; i<n+1; i++)
            sums[i] = sums[i-1] + nums[i-1];
        for (int i=0; i<n; i++) {
            if (sums[n]-nums[i] == 2*sums[i])
                return i;
        }
        return -1;
        */
    }
    public static void main (String args[]) {
     //   int[] testNums = {1, 7, 3, 6, 5, 6};
        int[] testNums = {};
        System.out.println(pivotIndex(testNums));
    }
}
