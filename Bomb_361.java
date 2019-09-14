class Bomb_361 {
    // Most voted solution
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int R = grid.length;
        int C = grid[0].length;
        int[] colhits = new int[C];
        int res = 0;
        for (int i = 0; i < R; i++) {
            int rowhits = 0;
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 'W') continue;
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowhits = 0;
                    for (int k = j; k < C && grid[i][k] != 'W'; k++) {
                        rowhits += (grid[i][k] == 'E' ? 1 : 0);
                    }
                }
                
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colhits[j] = 0;
                    for (int k = i; k < R && grid[k][j] != 'W'; k++) {
                        colhits[j] += (grid[k][j] == 'E' ? 1 : 0);
                    }
                }
                
                if (grid[i][j] == '0')
                    res = Math.max(res, rowhits + colhits[j]);
            }
        }
        return res;
    }
}