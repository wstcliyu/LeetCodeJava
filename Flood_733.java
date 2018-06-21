public class Flood_733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor)
            floodFillHelper(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    // dfs
    private void floodFillHelper(int[][] image, int x, int y, int newColor, int oldCorlor) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length)
            return;
        if (image[x][y] != oldCorlor)
            return;
        image[x][y] = newColor;
        floodFillHelper(image, x+1, y, newColor, oldCorlor);
        floodFillHelper(image, x-1, y, newColor, oldCorlor);
        floodFillHelper(image, x, y+1, newColor, oldCorlor);
        floodFillHelper(image, x, y-1, newColor, oldCorlor);
    }
}
