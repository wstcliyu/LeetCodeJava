class Unique_980 {
    // Most voted solution using backtrack and dfs
    int res = 0, empty = 1;
    int sx, sy, ex, ey;
    
    public int uniquePathsIII(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) empty++;
                if (grid[i][j] == 1) {
                    sx = i; sy = j;
                } else if (grid[i][j] == 2) {
                    ex = i; ey = j;
                }
            }
        }
        
        dfs(grid, sx, sy);
        return res;
    }
    
    private void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0) return;
        if (x == ex && y == ey) {
            if (empty == 0) res++;
            return;
        }
        grid[x][y] = -12345; // Use any negative number here to denote it has been visited
        empty--;
        dfs(grid, x-1, y);
        dfs(grid, x+1, y);
        dfs(grid, x, y-1);
        dfs(grid, x, y+1);
        grid[x][y] = 0;
        empty++;
    }




    // Standard solution #2: recursive dfs with memoization
    /*
    int ans;
    int[][] grid;
    int R, C;
    int tr, tc, target;
    int[] dr = new int[]{0, -1, 0, 1};
    int[] dc = new int[]{1, 0, -1, 0};
    Integer[][][] memo;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;
        target = 0;

        int sr = 0, sc = 0;
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                // save the grids that we need to visit
                // including the ending grid and all the empty grid
                if (grid[r][c] % 2 == 0)
                    target |= code(r, c); 

                if (grid[r][c] == 1) {
                    sr = r;
                    sc = c;
                } else if (grid[r][c] == 2) {
                    tr = r;
                    tc = c;
                }
            }

        memo = new Integer[R][C][1 << R*C];
        return dp(sr, sc, target);
    }

    public int code(int r, int c) {
        return 1 << (r * C + c);
    }

    public Integer dp(int r, int c, int todo) {
        if (memo[r][c][todo] != null)
            return memo[r][c][todo];

        if (r == tr && c == tc) {
            return todo == 0 ? 1 : 0;
        }

        int ans = 0;
        for (int k = 0; k < 4; ++k) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                if ((todo & code(nr, nc)) != 0)
                    ans += dp(nr, nc, todo ^ code(nr, nc));
            }
        }
        memo[r][c][todo] = ans;
        return ans;
    }
    */
}