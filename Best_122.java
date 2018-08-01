public class Best_122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int ans = 0;
        for (int i=0; i<prices.length-1; i++)
            ans += Math.max(0, prices[i+1]-prices[i]);
        return ans;
    }
}
