import java.util.List;

public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int res = Integer.MAX_VALUE;
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0)
                    dp[j] = triangle.get(i).get(j) + dp[j];
                else if (j == i)
                    dp[j] = triangle.get(i).get(j) + dp[j - 1];
                else
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j - 1]);
                if (i == n - 1)
                    res = Math.min(res, dp[j]);
            }
        }
        return res;
    }
}
