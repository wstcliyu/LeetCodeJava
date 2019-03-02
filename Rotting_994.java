import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Deque;

public class Rotting_994 {

    // My first solution using BFS
    public int orangesRotting(int[][] grid) {
        Deque<Point> q = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) q.addLast(new Point(i, j));
            }
        }

        int res = -1;
        boolean noRot = q.isEmpty();
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point p = q.removeFirst();
                bfs(grid, p, q);
            }
            res++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return noRot ? 0 : res;
    }


    private void bfs(int[][] grid, Point p, Deque<Point> q) {
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < 4; i++) {
            int x = p.x + dir[i][0];
            int y = p.y + dir[i][1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                q.addLast(new Point(x, y));
                grid[x][y] = 2;
            }
        }
    }
}
