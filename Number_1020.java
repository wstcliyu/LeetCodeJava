class Number_1020 {
    // My first solution

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
        if (i < 0 || j < 0 || i >= R || j >= C || A[i][j] == 0 || canGetBound) 
            return 0;
        if (i == 0 || j == 0 || i == R - 1 || j == C - 1) 
            canGetBound = true;
        A[i][j] = 0;
        return 1 + dfs(i + 1, j, A) + dfs(i - 1, j, A) + dfs(i, j + 1, A) + dfs(i, j - 1, A);
    }
}