import java.util.*;

class Shortest_1055 {
    public int shortestWay(String source, String target) {
        List<Integer> idx = new ArrayList<>();
        return 0;
    }

    // My first solution: DP
    /*
    public int shortestWay(String source, String target) {
        int n = target.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.max(0, i - source.length()); j < i; j++) {
                if (dp[j] < Integer.MAX_VALUE && isSubsequence(source, target.substring(j, i))) {
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                }
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
    
    private boolean isSubsequence(String source, String piece) {
        if (source.length() < piece.length()) return false;
        int i = 0, j = 0;
        while (i < source.length() && j < piece.length()) {
            if (source.charAt(i++) == piece.charAt(j)) {
                j++;
            }
        }
        return j == piece.length();
    }
    */
}