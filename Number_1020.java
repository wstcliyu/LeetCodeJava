class Number_1020 {
    // My updated solution
    class Result {
        int area;
        boolean enclave;
        Result() {
            area = 1;
            enclave = true;
        }
    }
    private int R, C;
    private int[][] grid;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int numEnclaves(int[][] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;
        int res = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    Result r = dfs(i, j);
                    res += r.enclave ? r.area : 0;
                }
            }
        }
        return res;
    }
    
    private Result dfs(int i, int j) {
        Result r = new Result();
        if (i == 0 || j == 0 || i == R - 1 || j == C - 1) r.enclave = false;
        grid[i][j] = 0;
        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < R && y >= 0 && y < C && grid[x][y] == 1) {
                Result t = dfs(x, y);
                r.area += t.area;
                r.enclave &= t.enclave;
            }
        }
        return r;
    }



    // My first solution
    /*
    boolean canGetBound = false;
    
    public int numEnclaves(int[][] A) {
        int count;
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    count = dfs(i, j, A);
                    if (!canGetBound) res += count;
                    canGetBound = false;
                }
            }
        }
        return res;
    }
    
    private int dfs(int i, int j, int[][] A) {
        int R = A.length, C = A[0].length;
        if (i < 0 || j < 0 || i >= R || j >= C || A[i][j] == 0) 
            return 0;
        if (i == 0 || j == 0 || i == R - 1 || j == C - 1) 
            canGetBound = true;
        A[i][j] = 0;
        return 1 + dfs(i + 1, j, A) + dfs(i - 1, j, A) + dfs(i, j + 1, A) + dfs(i, j - 1, A);
    }
    */
}