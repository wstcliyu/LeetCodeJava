public class Flood_733 {
    // DFS
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) floodFillHelper(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    private void floodFillHelper(int[][] image, int x, int y, int newColor, int oldCorlor) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != oldCorlor) return;
        floodFillHelper(image, x+1, y, newColor, oldCorlor);
        floodFillHelper(image, x-1, y, newColor, oldCorlor);
        floodFillHelper(image, x, y+1, newColor, oldCorlor);
        floodFillHelper(image, x, y-1, newColor, oldCorlor);
    }


    // BFS
    /*
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int oldColor, newColor;
    int[][] image;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image = image;
        this.newColor = newColor;
        this.oldColor = image[sr][sc];
        if (oldColor == newColor) return image;
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.add(new Point(sr, sc));
        while (!q.isEmpty()) {
            Point p = q.removeFirst();
            bfs(q, p);
        }
        return image;
    }
    
    private void bfs(ArrayDeque<Point> q, Point p) {
        image[p.x][p.y] = newColor;
        for (int[] d : directions) {
            Point tmp = new Point(p.x + d[0], p.y + d[1]);
            if (isValid(tmp)) q.addLast(tmp);
        }
    }
    
    private boolean isValid(Point p) {
        return p.x >= 0 && p.x < image.length && p.y >= 0 && p.y < image[0].length && image[p.x][p.y] == oldColor;
    }
    */
}
