import java.util.Arrays;
import java.util.Comparator;

class Video_1024 {
    public int videoStitching(int[][] clips, int T) {
        // Since this problem restricts clips[i][0] to be <= 100, so we can use bucket sort
        // Time: O(n), Space: O( max(clip[i][0]) )
        /*
        int[] bucket = new int[101];
        for (int[] c : clips) bucket[c[0]] = Math.max(bucket[c[0]], c[1]);
        int preMax, curMax = 0, res = 0, i = 0;
        do {
            res++;
            preMax = curMax;
            for (; i <= 100 && i <= preMax; i++)
                curMax = Math.max(curMax, bucket[i]);
        } while (curMax < T && preMax < curMax);

        return curMax >= T ? res : -1;
        */



        // My first solution using BFS (similar idea with my solution to Jump_45, Jump_55)
        // Time: O(nlgn), Space: O(1)
        Arrays.sort(clips, Comparator.<int[]>comparingInt(clip -> clip[0]));

        int preMax, curMax = 0, res = 0, i = 0;
        do {
            res++;
            preMax = curMax;
            for (; i < clips.length && clips[i][0] <= preMax; i++)
                curMax = Math.max(curMax, clips[i][1]);
        } while (curMax < T && preMax < curMax);
        
        return curMax >= T ? res : -1;    
    }



    // Good solution using DP
    // Time: O(nT^2), Space: O(T^2)
    /*
    public int videoStitching(int[][] clips, int T) {
        final int kInf = 101;
        int[][] dp = new int[T + 1][T + 1];
        for (int r = 0; r <= T; r++) for (int c = 0; c <= T; c++) dp[r][c] = kInf;
        for (int[] clip : clips) {
            final int s = clip[0], e = clip[1];
            for (int d = 1; d <= T; d++) {
                for (int i = 0; i <= T-d; i++) {
                    final int j = i + d;
                    if (s > j || e < i) continue;
                    if (s <= i && e >= j) dp[i][j] = 1;
                    else if (e >= j) dp[i][j] = Math.min(dp[i][j], 1 + dp[i][s]);
                    else if (s <= i) dp[i][j] = Math.min(dp[i][j], 1 + dp[e][j]);
                    else dp[i][j] = Math.min(dp[i][j], 1 + dp[i][s] + dp[e][j]);
                }
            }
        }
        return dp[0][T] == kInf ? -1 : dp[0][T];
    }
    */
}