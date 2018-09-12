public class Score_861 {
    // Standard Solution Approach #2 Greedy
    // Time: O(R*C), Space: O(1)
    /*
    public int matrixScore(int[][] A) {
        int R = A.length;
        int C = A[0].length;
        int ans = 0;
        for (int c = 0; c < C; c++) {
            int col = 0;
            for (int r = 0; r < R; r++)
                col += A[r][c] ^ A[r][0];
            // If A[r][0] == 1, then toggle this row; if A[r][0] == 0, then do nothing.
            // The first column will be toggled to 0s
            ans += Math.max(col, R - col) << (C - 1 - c);
        }
        return ans;
    }
    */

    // Standard Solution Approach #1 Brutal Force (Time Limit Exceeded)
    // Time: O(2^R * R * C), Space: O(C)
    public int matrixScore(int[][] A) {
        int R = A.length;
        int C = A[0].length;
        int ans = 0;
        int[] colsums = new int[C];

        for (int c = 0; c < C; c++)
            for (int r = 0; r < R; r++)
                colsums[c] += A[r][c];

        for (int state = 0; state < (1 << R); state++) {
            if (state == 0)
                continue;
            int trans = state ^ (state - 1); // trans represents the difference on every digit between state and state - 1
            for (int r = 0; r < R; r++) {
                if ((trans & (1 << r)) != 0) {
                    for (int c = 0; c < C; c++) {
                        colsums[c] += A[r][c] == 1 ? -1 : 1;
                        A[r][c] ^= 1; // x ^= 1 means toggle x
                    }
                }
            }

            int score = 0;
            for (int c = 0; c < C; c++)
                score += Math.max(colsums[c], R - colsums[c]) << (C - 1 - c);
            ans = Math.max(ans, score);
        }

        return ans;
    }
}
