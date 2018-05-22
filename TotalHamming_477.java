public class TotalHamming_477 {
    public static int totalHammingDistance(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i=0; i<32; i++) {
            int count = 0;
            for (int number:nums)
                count += (number>>i)&1;
            res += count * (n - count);
        }
        return res;
    }
    public static void main (String args[]) {
        int[] testNums = {4,14,2};
        System.out.println(totalHammingDistance(testNums));
    }
}
