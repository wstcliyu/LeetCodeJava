import java.util.Arrays;
import java.util.Collections;

public class Best_309 {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75931/Easiest-JAVA-solution-with-explanations
    /*
       buy[i]: Max profit till index i. The series of transaction is ending with a buy.
       sell[i]: Max profit till index i. The series of transaction is ending with a sell.
       buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
       sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
       Let b1, b0 represent buy[i - 1], buy[i]
       Let s2, s1, s0 represent sell[i - 2], sell[i - 1], sell[i]
    */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int b0, s0 = 0;
        int b1 = -prices[0];
        int s1 = 0, s2 = 0;
        for (int price : prices) {
            b0 = Math.max(b1, s2 - price);
            s0 = Math.max(s1, b1 + price);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        return s0;
    }


    // Another solution worth reading
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/Share-my-DP-solution-(By-State-Machine-Thinking)
    // This solution defines three states for any action sequence: Sell, Buy, Rest
    // Let s, b, n denote sell, buy, no action
    // If a sequence ends like {.....s}, it ends in Sell state
    // If a sequence ends like {.....s, n, n}, it ends in Rest state
    // If a sequence ends like {.....b}, it ends in Buy state
    // If a sequence ends like {.....b, n, n}, it is also regarded as ending in Buy state


    public static void main(String[] args) {
        Best_309 test = new Best_309();
        int[] testPrices = {6,1,3,2,4,7};
        System.out.println(test.maxProfit(testPrices));
    }
}
