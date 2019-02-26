import java.util.*;

public class Word_139 {
    // DP
    /*
    public boolean wordBreak(String s, List<String> wordDict) {
        int N = s.length();
        boolean[] dp = new boolean[N+1];
        dp[0] = true;
        for (int i = 1; i <= N; i++) {
            for (int j = i-1; j >= 0 && !dp[i]; j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i)))
                    dp[i] = true;
            }
        }
        return dp[N];
    }
    */


    // DP
    public boolean wordBreak(String s, List<String> wordDict) {
        int N = s.length();
        boolean[] dp = new boolean[N + 1];
        dp[0] = true;
        for (int i = 1; i <= N; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (len <= i && dp[i - len] && word.equals(s.substring(i-len, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }


    // BFS
    /*
    public boolean wordBreak(String s, List<String> wordDict) {
        int N = s.length();
        boolean[] visited = new boolean[N];
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        while (!q.isEmpty()) {
            int start = q.removeFirst();
            if (visited[start]) continue;
            visited[start] = true;
            for (String word : wordDict) {
                int len = word.length();
                int end = start + len;
                if (end <= N && word.equals(s.substring(start, end))) {
                    if (end == N) return true;
                    q.addLast(end);
                }
            }
        }
        return false;
    }
    */
}
