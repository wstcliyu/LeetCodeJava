class Longest_562 {
    // Standard Solution #2: DP
    public int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) return 0;
        int R = M.length;
        int C = M[0].length;
        int res = 0;
        int[][][] dp = new int[R][C][4];
        int[][] directions = {{0, -1}, {-1, 0}, {-1, -1}, {-1, 1}};
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (M[i][j] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    dp[i][j][k] = 1;
                    int x = i + directions[k][0];
                    int y = j + directions[k][1];
                    if (x >= 0 && y >= 0 && y < C)
                        dp[i][j][k] = 1 + dp[x][y][k];
                    res = Math.max(res, dp[i][j][k]);
                }
            }
        }
        return res;
    }




    // Standard Solution #1: Brute Force
    /*
    public int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) return 0;
        int R = M.length;
        int C = M[0].length;
        int res = 0;
        
        for (int i = 0; i < R; i++) {
            int count = 0;
            for (int j = 0; j < C; j++) {
                if (M[i][j] == 1) count++;
                else count = 0;
                res = Math.max(res, count);
            }
        }
        
        for (int j = 0; j < C; j++) {
            int count = 0;
            for (int i = 0; i < R; i++) {
                if (M[i][j] == 1) count++;
                else count = 0;
                res = Math.max(res, count);
            }
        }
        
        for (int sum = 0; sum < R + C - 1; sum++) {
            int count = 0;
            int i = Math.min(R - 1, sum);
            int j = sum - i;
            for (; i >= 0 && j < C; i--, j++) {
                if (M[i][j] == 1) count++;
                else count = 0;
                res = Math.max(res, count);
            }
        }
        
        for (int dif = R - 1; dif >= 1 - C; dif--) {
            int count = 0;
            int i = Math.max(dif, 0);
            int j = i - dif;
            for (; i < R && j < C; i++, j++) {
                if (M[i][j] == 1) count++;
                else count = 0;
                res = Math.max(res, count);
            }
        }
        
        return res;
    }
    */
}