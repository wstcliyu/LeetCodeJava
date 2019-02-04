import java.util.Arrays;

public class Minimum_983 {
    // DP from back forward
    public int mincostTickets(int[] days, int[] costs) {
        int[] pass = {1, 7, 30};
        int N = days.length;
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = N - 1; i >= 0; i--) {
            int j = i;
            for (int k = 0; k < 3; k++) {
                while (j < N && days[i] + pass[k] > days[j]) j++;
                dp[i] = Math.min(dp[i], costs[k] + (j < N ? dp[j] : 0));
            }
        }
        return dp[0];
    }
}
