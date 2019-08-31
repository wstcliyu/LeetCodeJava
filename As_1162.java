import java.util.*;

class As_1162 {
    // My first solution: BFS
    public int maxDistance(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        boolean[][] visited = new boolean[R][C];
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    q.add(new int[]{i, j});
                }
            }
        }
        if (q.size() == 0 || q.size() == R * C) {
            return -1;
        }
        
        int res = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!q.isEmpty()) {
            int len = q.size();
            for (int k = 0; k < len; k++) {
                int[] start = q.removeFirst();
                for (int[] d : directions) {
                    int x = start[0] + d[0];
                    int y = start[1] + d[1];
                    if (x >= 0 && x < R && y >= 0 && y < C && !visited[x][y]) {
                        visited[x][y] = true;
                        q.add(new int[]{x, y});
                    }
                }
            }
            if (!q.isEmpty()) res++;
        }
        return res;
    }
}