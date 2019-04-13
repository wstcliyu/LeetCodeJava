class Solution {
    // Most voted solution using only one extra matrix
    // Time: O(N^2), Space: O(N^2)
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
            
        for (int i = 0; i < N; i++) Arrays.fill(grid[i], N);
            
        for (int[] m : mines) grid[m[0]][m[1]] = 0;
            
        for (int i = 0; i < N; i++) {
            for (int j = 0, k = N - 1, l = 0, r = 0, u = 0, d = 0; j < N; j++, k--) {
                grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1));  // left direction
                grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1));  // right direction
                grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1));  // up direction
                grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1));  // down direction
            }
        }
            
        int res = 0;
            
        for (int[] row : grid) for (int x : row) res = Math.max(res, x);
            
        return res;
    }




    // Standard solution using one extra matrix and one extra hashset
    /*
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] dp = new int[N][N];
        Set<Integer> banned = new HashSet<>();
        for (int[] m : mines) banned.add(m[0] * N + m[1]);
        int count, res = 0;
        for (int r = 0; r < N; r++) {
            count = 0;
            for (int c = 0; c < N; c++) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = count;
            }
            
            count = 0;
            for (int c = N - 1; c >= 0; c--) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }
        
        for (int c = 0; c < N; c++) {
            count = 0;
            for (int r = 0; r < N; r++) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
            
            count = 0;
            for (int r = N - 1; r >= 0; r--) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
                res = Math.max(res, dp[r][c]);
            }
        }
        
        return res;
    }
    */
}