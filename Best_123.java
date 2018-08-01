public class Best_123 {
    public static int maxProfit(int[] prices) {
        // p1 = max(-x)
        // p2 = max(-x+y)
        // p3 = max(-x+y-z)
        // p4 = max(-x+y-z+w)
        int p1 = Integer.MIN_VALUE, p3 = Integer.MIN_VALUE;
        int p2 = 0, p4 = 0;
        for (int i:prices) {
            p1 = Math.max(p1, -i);
            p2 = Math.max(p2, p1+i);
            p3 = Math.max(p3, p2-i);
            p4 = Math.max(p4, p3+i);
        }
        return p4;
    }
    public static void main (String args[]) {
        int[] testPrices = {1,4,2,1};
        System.out.println(maxProfit(testPrices));
    }
}
