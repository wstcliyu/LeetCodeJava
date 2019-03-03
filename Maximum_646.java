import java.util.Arrays;
import java.util.Comparator;

public class Maximum_646 {
    // Standard solution #1: DP
    // Time: O(n^2), Space: O(n)
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparing((int[] p) -> p[0]));
        int res = 0;
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }



    // Standard solution #2: Greedy
    // Time: O(nlgn), Space: O(1)
    /*
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparing((int[] p) -> p[1]));
        int res = 0;
        int end = Integer.MIN_VALUE;
        for (int[] p : pairs) {
            if (p[0] > end) {
                res++;
                end = p[1];
            }
        }
        return res;
    }
    */
}
