public class Minimum_931 {
    public int minFallingPathSum(int[][] A) {
        int N = A.length;
        int[] pre = new int[N], cur = new int[N];
        for (int[] row : A) {
            cur = new int[N];
            for (int i = 0; i < N; i++) {
                int left = i > 0 ? pre[i - 1] : Integer.MAX_VALUE;
                int right = i < N - 1 ? pre[i + 1] : Integer.MAX_VALUE;
                cur[i] = row[i] + Math.min(pre[i], Math.min(left, right));
            }
            pre = cur;
        }
        int res = cur[0];
        for (int v : cur) res = Math.min(res, v);
        return res;
    }
}
