class Longest_329 {
    // Standard solution #2: DFS + Memoization
    // Time: O(m*n), Space(m*n)
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        m = matrix.length; n = matrix[0].length;
        int[][] cache = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                ans = Math.max(ans, dfs(matrix, i, j, cache));
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j])
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
        }
        return ++cache[i][j];
    }



    // Rewrite standard solution #3: Topological Sort
    // Time: O(m*n), Space(m*n)
    // Standard solution uses out-degree of each node to form Topological Sort from leaf to root
    // I use in-degree of each node to form Topological Sort from root to leaf
    /*
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        int[][] inDegree = new int[m][n];
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int[] d : dirs) {
                    int x = i + d[0], y = j + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                        inDegree[x][y]++;
                    }
                }
            }
        }
        
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (inDegree[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }
        
        int ans = 0;
        while (!q.isEmpty()) {
            ans++;
            for (int k = q.size(); k > 0; k--) {
                int[] node = q.removeFirst();
                for (int[] d : dirs) {
                    int x = node[0] + d[0], y = node[1] + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[node[0]][node[1]]) {
                        if (--inDegree[x][y] == 0) {
                            q.add(new int[]{x, y});
                        }
                    }
                }
            }
        }
        return ans;
    }
    */
}