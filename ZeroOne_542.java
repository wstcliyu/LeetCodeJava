import java.util.Deque;
import java.util.ArrayDeque;

class ZeroOne_542 {
    // My first solution using BFS with visited matrix
    public int[][] updateMatrix(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length;
        int[][] res = new int[R][C];
        boolean[][] visited = new boolean[R][C];
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (matrix[i][j] == 0) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
        
        int dist = 0;    
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] cur = q.removeFirst();
                res[cur[0]][cur[1]] = dist;
                for (int[] d : dir) {
                    int x = cur[0] + d[0], y = cur[1] + d[1];
                    if (x >= 0 && x < R && y >= 0 && y < C && !visited[x][y]) {
                        visited[x][y] = true;
                        q.add(new int[]{x, y});
                    }
                }
            }
            dist++;
        }
        
        return res;
    }




    // Standard solution #1: BFS without visited matrix
    /*
    public int[][] updateMatrix(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length;
        int[][] res = new int[R][C];
        for (int i = 0; i < R; i++) for (int j = 0; j < C; j++) res[i][j] = Integer.MAX_VALUE;
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    q.add(new int[]{i, j});
                }
        
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            for (int[] d : dir) {
                int x = cur[0] + d[0], y = cur[1] + d[1];
                if (x >= 0 && x < R && y >= 0 && y < C && res[x][y] > 1 + res[cur[0]][cur[1]]) {
                    res[x][y] = 1 + res[cur[0]][cur[1]];
                    q.add(new int[]{x, y});
                }
            }
        }
        
        return res;
    }
    */




    // Standard solution #2: DP
    /*
    public int[][] updateMatrix(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length;
        int[][] dist = new int[R][C];

        //First pass: check for left and top
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) dist[i][j] = 0;
                else {
                    if (i > 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    if (j > 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }

        //Second pass: check for bottom and right
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i < rows - 1)
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                if (j < cols - 1)
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
            }
        }

        return dist;
    }
    */
}