import java.util.Arrays;

public class Best_188 {
    public int maxProfit(int k, int[] prices) {
        // Avoid TLE
        int len = prices.length;
        if (k >= len / 2)
            return quickSolve(prices);

        // Most voted solution
        /*
        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
        */

        // Similar as Best_123
        int[] buy = new int[k+1];
        int[] sell = new int[k+1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int i:prices) {
            for (int j=1; j<=k; j++) {
                buy[j] = Math.max(buy[j], -i + sell[j-1]);
                sell[j] = Math.max(sell[j], i + buy[j]);
            }
        }
        return sell[k];
    }
    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
