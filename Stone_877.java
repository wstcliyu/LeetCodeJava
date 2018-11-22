import java.util.Arrays;

public class Stone_877 {
    // Most voted solution using 2D DP
    // dp[i][j] means the biggest number of stones you can get more than opponent picking piles in piles[i] ~ piles[j].
    // You can first pick piles[i] or piles[j]
    // If you pick piles[i], your result will be piles[i] - dp[i + 1][j]
    // If you pick piles[j], your result will be piles[j] - dp[i][j - 1]
    public boolean stoneGame(int[] p) {
        int n = p.length;
        int[][] dp  = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = p[i];
        for (int d = 1; d < n; d++)
            for (int i = 0; i < n - d; i++)
                dp[i][i + d] = Math.max(p[i] - dp[i + 1][i + d], p[i + d] - dp[i][i + d - 1]);
        return dp[0][n - 1] > 0;
    }

    // Most voted solution using 1D DP
    // Since dp[i+1][i+d] and dp[i][i+d-1] both have the property:
    // (i+d) - (i+1) = d-1, (i+d-1) - i = d-1
    // they can represented by dp[i+1] and dp[i]
    /*
    public boolean stoneGame(int[] p) {
        int n = p.length;
        int[] dp = Arrays.copyOf(p, n);
        for (int d = 1; d < n; d++)
            for (int i = 0; i < n - d; i++)
                dp[i] = Math.max(p[i] - dp[i + 1], p[i + d] - dp[i]);
        return dp[0] > 0;
    }
    */

    // My first solution using 2D DP
    // dp[i][i+j] denotes max value that can be achieved by picking first
    // dp[i+j][i] denotes max value that can be achieved by picking second
    /*
    public boolean stoneGame(int[] piles) {
        int N = piles.length;
        int[] sums = new int[N + 1];
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            sums[i + 1] = sums[i] + piles[i];
            dp[i][i] = piles[i];
        }
        for (int j = 1; j < N; j++) {
            for (int i = 0; i + j < N; i++) {
                dp[i][i + j] = Math.max(dp[i + j - 1][i] + piles[i + j], dp[i + j][i + 1] + piles[i]);
                dp[i + j][i] = - dp[i][i + j] + sums[i + j + 1] - sums[i];
            }
        }
        return dp[0][N - 1] * 2 > sums[N];
    }
    */
}
