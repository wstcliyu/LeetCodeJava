class Pacific_417 {
    // Most voted solution using BFS
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Deque<int[]> pQueue = new ArrayDeque<>();
        Deque<int[]> aQueue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            pacific[i][0] = true;
            atlantic[i][n-1] = true;
            pQueue.add(new int[]{i, 0});
            aQueue.add(new int[]{i, n-1});
        }
        for (int j = 0; j < n; j++) {
            pacific[0][j] = true;
            atlantic[m-1][j] = true;
            pQueue.add(new int[]{0, j});
            aQueue.add(new int[]{m-1, j});
        }
        bfs(pacific, pQueue, matrix);
        bfs(atlantic, aQueue, matrix);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i, j});
        return res;
    }
    
    private void bfs(boolean[][] visited, Deque<int[]> queue, int[][] matrix) {
        while (!queue.isEmpty()) {
            int[] cur = queue.removeFirst();
            for (int[] d : dir) {
                int x = cur[0] + d[0], y = cur[1] + d[1];
                if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && !visited[x][y] && matrix[x][y] >= matrix[cur[0]][cur[1]]) {
                    visited[x][y] = true;
                    queue.add(new int[]{x, y});
                }
            }
        }
    }




    // Most voted solution using DFS
    /*
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(pacific, matrix, i, 0);
            dfs(atlantic, matrix, i, n-1);
        }
        for (int j = 0; j < n; j++) {
            dfs(pacific, matrix, 0, j);
            dfs(atlantic, matrix, m-1, j);
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i, j});
        return res;
    }
    
    private void dfs(boolean[][] visited, int[][] matrix, int i, int j) {
        if (visited[i][j]) return;
        visited[i][j] = true;
        for (int[] d : dir) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && !visited[x][y] && matrix[x][y] >= matrix[i][j])
                dfs(visited, matrix, x, y);
        }
    }
    */
}