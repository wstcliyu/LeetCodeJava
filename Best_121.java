public class Best_121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int min = prices[0];
        int ans = 0;
        for (int p : prices) {
            min = Math.min(p, min);
            ans = Math.max(p-min, ans);
        }
        return ans;
    }
}
