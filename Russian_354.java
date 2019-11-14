import java.util.Arrays;

class Russian_354 {
    // Standard solution: Sort + Longest Increasing Subsequence
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]));
        int[] secondDim = new int[n];
        for (int i = 0; i < n; i++) {
            secondDim[i] = envelopes[i][1];
        }
        return lengthOfLIS(secondDim);
    }
    
    private int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) i = - i - 1;
            dp[i] = num;
            if (i == len) len++;
        }
        return len;
    }
}