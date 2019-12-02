import java.awt.Point;
import java.util.*;

class Solution {
    // My first solution: BFS (Time Limit Exceeded)
    /*
    int[][] directions = new int[][]{{1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}, {-1, 2}, {-2, 1}};
    
    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) return 0;
        int res = 0;
        Deque<Point> q = new ArrayDeque<>();
        HashSet<Point> visited = new HashSet<>();
        Point start = new Point(0, 0);
        q.add(start);
        visited.add(start);
        while (!q.isEmpty()) {
            res++;
            for (int i = q.size(); i > 0; i--) {
                Point p = q.removeFirst();
                for (int[] d : directions) {
                    int a = p.x + d[0];
                    int b = p.y + d[1];
                    if (x == a && y == b) return res;
                    Point next = new Point(a, b);
                    if (visited.add(next)) q.add(next);
                }
            }
        }
        return -1;
    }
    */
}