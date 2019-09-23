import java.util.Arrays;

class Filling_1105 {
    // Most voted solution
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= books.length; i++) {
            int h = 0;
            for (int j = i - 1, w = 0; j >= 0 && w + books[j][0] <= shelf_width; j--) {
                w += books[j][0];
                h = Math.max(h, books[j][1]);
                dp[i] = Math.min(dp[i], dp[j] + h);
            }
        }
        return dp[books.length];
    }
}