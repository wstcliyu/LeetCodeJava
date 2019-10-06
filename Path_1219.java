class Path_1219 {
    // My first solution: Backtrack
    private int res, R, C;
    private int[][] directions;
    
    public int getMaximumGold(int[][] grid) {
        res = 0;
        R = grid.length;
        C = grid[0].length;
        directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] > 0)
                    backtrack(i, j, 0, grid);
            }
        }
        return res;
    }
    
    private void backtrack(int i, int j, int sum, int[][] grid) {
        int val = grid[i][j];
        res = Math.max(res, sum + val);
        grid[i][j] = 0;
        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && y >= 0 && x < R && y < C && grid[x][y] > 0)
                backtrack(x, y, sum + val, grid);
        }
        grid[i][j] = val;
    }
}