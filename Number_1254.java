class Number_1254 {
    // My first solution: DFS
    // Check whether the island has any grid at the edges
    private int R, C;
    private int[][] grid;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int closedIsland(int[][] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;
        int res = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 0 && dfs(i, j)) {
                    res++;
                }
            }
        }
        return res;
    }
    
    private boolean dfs(int i, int j) {
        boolean closedIsland = true;
        if (i == 0 || j == 0 || i == R - 1 || j == C - 1) closedIsland = false;
        grid[i][j] = 1;
        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < R && y >= 0 && y < C && grid[x][y] == 0) {
                closedIsland &= dfs(x, y);
            }
        }
        return closedIsland;
    }
}