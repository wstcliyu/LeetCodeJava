public class Maximum_643 {
    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for (int i=0; i<k; i++)
            sum += nums[i];
        int temp = sum;
        for (int i=k; i<n; i++) {
            temp = temp + nums[i] - nums[i-k];
            sum = Math.max(sum,temp);
        }
        double result = sum*1.0/k;
        return result;
    }
    public static void main (String args[]) {
        int[] testNums = {1,12,-5,-6,50,3};
        int testK = 4;
        System.out.println(findMaxAverage(testNums, testK));
    }
}
